package app

import app.views.push.PushView
import com.vaadin.annotations.Push
import com.vaadin.navigator.Navigator
import com.vaadin.server.VaadinRequest
import com.vaadin.ui.UI

@Push
class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        Navigator navigator = new Navigator(this, this)
        navigator.addView(PushView.VIEW_NAME, PushView)

        navigator.navigateTo(PushView.VIEW_NAME)
    }
}
