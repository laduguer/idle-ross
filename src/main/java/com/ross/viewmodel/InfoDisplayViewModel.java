package com.ross.viewmodel;

import java.util.List;

public class InfoDisplayViewModel {

    private List<FadingInfoMessageViewModel> messsages;


    public InfoDisplayViewModel(List<FadingInfoMessageViewModel> messsages) {
        this.messsages = messsages;
    }


    public List<FadingInfoMessageViewModel> getMesssages() {
        return messsages;
    }
}
