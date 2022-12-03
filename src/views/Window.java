package views;

import views.splash.JDialogSplash;
import views.statistic.ClientAttention;
import views.statistic.ClientNoAttention;
import views.statistic.JDialogStatistic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    private MainPanel mainPanel;
    private JDialogSplash jDialogSplash;
    private ClientAttention clientAttention;
    private ClientNoAttention clientNoAttention;
    private JDialogStatistic jDialogStatistic;

    public Window(ActionListener listener) {
        this.setIconImage( new ImageIcon(getClass().getResource( Constant.IMG_LOGO)).getImage());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle( Constant.TITLE_STORE);
//        this.setExtendedState(MAXIMIZED_BOTH);
        this.setSize(new Dimension((int) (Constant.SCREEN_SIZE.getWidth()*0.7),(int) (Constant.SCREEN_SIZE.getHeight()*0.7)));
        this.setMinimumSize(new Dimension((int) (Constant.SCREEN_SIZE.getWidth()*0.7),(int) (Constant.SCREEN_SIZE.getHeight()*0.7)));
        initComponents(listener);
        this.setVisible(false);
    }

    public void initComponents(ActionListener listener){

        jDialogSplash = new JDialogSplash(listener,this);
        jDialogStatistic = new JDialogStatistic(listener,this);
        clientAttention = new ClientAttention(listener,this);
        clientNoAttention = new ClientNoAttention(listener,this);

        mainPanel = new MainPanel(listener);
        this.getContentPane().add(mainPanel, BorderLayout.CENTER);
    }


    public void setVisibleSplash(boolean active){
        this.jDialogSplash.setVisible(active);
    }

    public String[] getDatesSimulation(){
        return jDialogSplash.getDatesSimulation();
    }

    public void setIconBarber(String path){
        mainPanel.setIconBarber(path);
    }

    public void setTimeAttentionBarber(int time){
        mainPanel.setTimeAttentionBarber(time);
    }

    public void setStateBarberLa1bel(String text){
        mainPanel.setStateBarberLa1bel(text);
    }

    public void setVisibleClientAttention(boolean status){
        clientAttention.setVisible(status);
    }
    public void setVisibleClientNoAttention(boolean status){
        clientNoAttention.setVisible(status);
    }

    public void setVisibleStatistic(boolean status){
        jDialogStatistic.setVisible(status);
    }

}

