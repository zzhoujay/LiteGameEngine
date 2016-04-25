package com.zzhoujay.litegameengine.graphics;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import com.zzhoujay.litegameengine.core.CoreEngine;
import com.zzhoujay.litegameengine.core.WorkThread;

/**
 * Created by zhou on 16-4-25.
 */
public abstract class GraphicsEngine extends CoreEngine{

    private Renderable render;

    protected final SurfaceHolder holder;

    public GraphicsEngine(SurfaceHolder holder) {
        this.holder = holder;
    }

    public Renderable getRender() {
        return render;
    }

    public void setRender(Renderable render) {
        this.render = render;
    }

    public class GraphicsEngineThread extends WorkThread {
        public GraphicsEngineThread(int intervalTime) {
            super(intervalTime);
        }

        @Override
        protected void work() {
            if (holder == null) {
                return;
            }
            synchronized (holder) {
                Canvas canvas = holder.lockCanvas();
                render.render(canvas);
                holder.unlockCanvasAndPost(canvas);
            }
        }
    }
}
