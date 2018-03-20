package in.creativelizard.creativelizard.aplications;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by siddhartha on 13/3/18.
 */

public class CreativelizardAplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
