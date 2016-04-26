package com.cy.yangbo.album3d.view;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Administrator on 2016/4/26.
 */
public class AlbumView extends GLSurfaceView{

    private Renderer mRenderer;

    public AlbumView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mRenderer = new AlbumRender();
        this.setRenderer(mRenderer);
    }

    public class AlbumRender implements Renderer {

        @Override
        public void onSurfaceCreated(GL10 gl, EGLConfig config) {

        }

        @Override
        public void onSurfaceChanged(GL10 gl, int width, int height) {

        }

        @Override
        public void onDrawFrame(GL10 gl) {

        }
    }
}
