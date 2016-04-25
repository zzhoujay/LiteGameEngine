package com.zzhoujay.litegameengine.core;

import com.zzhoujay.litegameengine.Physics.PhysicsEngine;
import com.zzhoujay.litegameengine.actions.ActionEngine;
import com.zzhoujay.litegameengine.audios.AudioEngine;
import com.zzhoujay.litegameengine.graphics.GraphicsEngine;

/**
 * Created by zhou on 16-4-25.
 */
public class MainEngine extends CoreEngine {

    private ActionEngine actionEngine;
    private AudioEngine audioEngine;
    private GraphicsEngine graphicsEngine;
    private PhysicsEngine physicsEngine;

    @Override
    public void startUp() {
        actionEngine.startUp();
        audioEngine.startUp();
        graphicsEngine.startUp();
    }

    @Override
    public void shutdown() {
        actionEngine.shutdown();
        audioEngine.shutdown();
        graphicsEngine.shutdown();
        physicsEngine.shutdown();
    }

}
