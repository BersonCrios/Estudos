package io.github.bersoncrios.projetopadraohackathon;

import io.github.bersoncrios.projetopadraohackathon.AndGraph.AGGameManager;
import io.github.bersoncrios.projetopadraohackathon.AndGraph.AGScene;
import io.github.bersoncrios.projetopadraohackathon.AndGraph.AGTimer;

public class TelaSobre extends AGScene {

    AGTimer tempoTroca = null;


    /*******************************************
     * Name: CAGScene()
     * Description: Scene construtor
     * Parameters: CAGameManager
     * Returns: none
     *****************************************
     * @param pManager*/
    public TelaSobre(AGGameManager pManager) {
        super(pManager);
    }

    @Override
    public void init() {
        tempoTroca = new AGTimer(1000);
        setSceneBackgroundColor(0,0,1);
    }

    @Override
    public void restart() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void loop() {
        tempoTroca.update();

        if (tempoTroca.isTimeEnded()){
            this.vrGameManager.setCurrentScene(3);
        }
    }
}
