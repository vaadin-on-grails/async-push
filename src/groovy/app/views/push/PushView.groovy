package app.views.push

import app.MyUI
import com.vaadin.navigator.View
import com.vaadin.navigator.ViewChangeListener
import com.vaadin.ui.Label
import com.vaadin.ui.VerticalLayout

class PushView extends VerticalLayout implements View {

    static final String VIEW_NAME = "push"

    Label loadingText = new Label("Loading UI, please wait...");

    @Override
    void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        loadingText.setSizeUndefined();
        addComponent(loadingText);
        new Pusher().start();
    }

    class Pusher extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000)
            } catch (InterruptedException e) {
                e.printStackTrace()
            }

            MyUI.current.access(new Runnable() {
                @Override
                public void run() {
                    loadingText.setValue("Done!")
                }
            });
        }
    }
}
