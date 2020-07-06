package com.ross.ui;

import com.ross.game.GenericUpdateListener;
import com.ross.game.InfoHolder;
import com.ross.viewmodel.FadingInfoMessageViewModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InfoPanel extends JPanel implements GenericUpdateListener {

    private final List<JTextField> infoLines;
    private final InfoHolder infoHolder;


    public InfoPanel(InfoHolder infoHolder) {

        infoLines = IntStream.range(0, infoHolder.maxMessages())
                .mapToObj(i -> new JTextField())
                .collect(Collectors.toList());
        this.infoHolder = infoHolder;

        setLayout(new GridLayout(infoHolder.maxMessages(), 1, 5, 5));


        infoLines.forEach(this::add);

        setVisible(true);

        infoHolder.addListener(this);

    }


    @Override
    public void updated() {
        List<FadingInfoMessageViewModel> messsages = infoHolder.getInfoDisplay()
                .getMesssages();

        for(int i = 0; i < messsages.size(); i ++){
            infoLines.get(i).setText(messsages.get(i).message);
            infoLines.get(i).setBackground(messsages.get(i).color());
        }
        for(int i = messsages.size(); i < infoLines.size(); i++){
            infoLines.get(i).setText("");
            infoLines.get(i).setBackground(Color.WHITE);
        }

    }
}
