package io.github.bersoncrios.projetopadraohackathon;

import io.github.bersoncrios.projetopadraohackathon.AndGraph.AGGameManager;
import io.github.bersoncrios.projetopadraohackathon.AndGraph.AGScene;
import io.github.bersoncrios.projetopadraohackathon.AndGraph.AGTimer;

public class TelaMenu extends AGScene {

    AGTimer tempoTroca = null;

    /*******************************************
     * Name: CAGScene()
     * Description: Scene construtor
     * Parameters: CAGameManager
     * Returns: none
     *****************************************
     * @param pManager*/
    public TelaMenu(AGGameManager pManager) {
        super(pManager);
    }

    @Override
    public void init() {
        tempoTroca = new AGTimer(1000);
        setSceneBackgroundColor(1,0,0);
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
            this.vrGameManager.setCurrentScene(2);
        }
    }
}
