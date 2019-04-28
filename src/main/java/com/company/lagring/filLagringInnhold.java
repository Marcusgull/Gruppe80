package com.company.lagring;

import javafx.stage.Stage;

public class filLagringInnhold {
    private FilLagringStrategy filLagringStrategy;

    public filLagringInnhold (FilLagringStrategy filLagringStrategy){
        this.filLagringStrategy = filLagringStrategy;
    }

    public void lagreTilFil (Stage stage, int verdi){
        filLagringStrategy.lagre(stage, verdi);
    }
}
