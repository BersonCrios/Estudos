import MySQLdb
import os
import commands
import time

db = MySQLdb.connect("10.10.10.90","root","unitins","VareduraWifi" )
cursor = db.cursor()

iwListscanerChannel = "iwlist wlp1s0 scan | grep Channel"
iwListscanerAddress = "iwlist wlp1s0 scan | grep Address"
iwListscanerSSID = "iwlist wlp1s0 scan | grep ESSID"
iwListscanerFrequency = "iwlist wlp1s0 scan | grep Frequency"
iwListscanerQuality = "iwlist wlp1s0 scan | grep Quality"
iwListscanerLast = "iwlist wlp1s0 scan | grep Extra"

scanningSSID = commands.getoutput(iwListscanerSSID)
scanningAddress = commands.getoutput(iwListscanerAddress)
scanningFrequency = commands.getoutput(iwListscanerFrequency)
scanningLast = commands.getoutput(iwListscanerLast)

scanningChannel = commands.getoutput(iwListscanerChannel)
scanningQuality = commands.getoutput(iwListscanerQuality)


splitSSDID = scanningSSID.split(':')

splitAddress = scanningAddress.split("-")
splitMac = splitAddress[1].split(" ")

splitFrequency = scanningFrequency.split(":")
splitFrequencyUnico = splitFrequency[1].split("(")
splitFrequencyNumber = splitFrequencyUnico[0].split(" ")

splitLast = scanningLast.split(":")
splitLastBeacon = splitLast[3].split(" ")
splitLastBeaconNumber = splitLastBeacon[1].split("m")

splitChannelFrequency =  scanningChannel.split("\n")
splitChannel = splitChannelFrequency[0].split(":")

splitQualityLevel = scanningQuality.split(" ")
splitLevel = splitQualityLevel[23].split("=")

splitQualityNumber = splitQualityLevel[20].split("=")
splitQualityNumeroParaFormula = splitQualityNumber[1].split("/")

qualityPos0 = int(splitQualityNumeroParaFormula[0])
qualityPos1 = int(splitQualityNumeroParaFormula[1])


qualidadePercent = (qualityPos0 * 100) / qualityPos1

qualidadeString = str(qualidadePercent)


ssid = splitSSDID[1]
Mac = splitMac[2]
Frequencia = splitFrequencyNumber[0]
LastBeacon = splitLastBeaconNumber[0]
Canal = splitChannel[1]
nivel = splitLevel[1]
qualidade = qualidadeString



arquivo = open("wifiArea.txt", "w")
arquivo.write(splitSSDID[1])
arquivo.write("\n\n")
arquivo.write(splitMac[2])
arquivo.write("\n\n")
arquivo.write(splitFrequencyNumber[0])
arquivo.write("\n\n")
arquivo.write(splitLastBeaconNumber[0])
arquivo.write("\n\n")
arquivo.write(splitChannel[1])
arquivo.write("\n\n")
arquivo.write(splitLevel[1])
arquivo.write("\n\n")
arquivo.write(qualidadeString)
arquivo.close()





def escreveNoBanco():

    sqlEscritor = "INSERT INTO Rede (Nome_rede, \
           MAC_AP,Qualidade_link,Nivel_sinal,\
           Canal, Frequencia,Last_beacon) \
           VALUES ('%s', '%s', '%s', '%s', '%s','%s','%s' )" % \
          (ssid, Mac, qualidade, nivel, Canal, Frequencia, LastBeacon)

    try:
        cursor.execute(sqlEscritor)
        db.commit()
    except:
        db.rollback()





def lerDoBanco():
    sqlLeitor = "SELECT * FROM VareduraWifi.Rede"

    try:
        cursor.execute(sqlLeitor)

        for row in cursor.fetchall():
            print "---------------------------------------------------------------------------------------------------------------------------------------------"
            print "       ID  ","       SSID  ","            MAC  ","          QUALIDADE  ", "   NIVEL  "," CANAL  "," FREQUENCIA  ","LAST BEACON  "
            print "      ", row[0], "      ", row[1],"      ", row[2],"       ", row[3],"      ", row[4],"      ", row[5],"      ", row[6], "      ", row[7]
            print "---------------------------------------------------------------------------------------------------------------------------------------------"
            print "\n"
    except:
        print "Erro ao exibir dados"

    db.close()


escreveNoBanco()
time.sleep(1)
lerDoBanco()