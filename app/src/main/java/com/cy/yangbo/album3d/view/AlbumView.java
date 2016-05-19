package com.cy.yangbo.album3d.view;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

import com.cy.yangbo.album3d.util.Cube;
import com.cy.yangbo.album3d.util.MatrixState;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Administrator on 2016/4/26.
 */
public class AlbumView extends GLSurfaceView{

    private Renderer mRenderer;

    private Cube mCube;

    public AlbumView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setEGLContextClientVersion(2);

        mRenderer = new AlbumRender();
        this.setRenderer(mRenderer);
    }

    public class AlbumRender implements Renderer {

        @Override
        public void onSurfaceCreated(GL10 gl, EGLConfig config) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glEnable(GLES20.GL_DEPTH_TEST);

            MatrixState.setCamere(0.0f, 0.0f, -0.5f,
                    0.0f, 0.0f, -5.0f,
                    0.0f, 1.0f, 0.0f);
            mCube = new Cube(AlbumView.this);
            mCube.initVertexData();
            mCube.initShader();
        }

        @Override
        public void onSurfaceChanged(GL10 gl, int width, int height) {
            GLES20.glViewport(0, 0, width, height);
            float ratio = (float)width / height;

            MatrixState.setProjectFrustum(-ratio, ratio, -1.0f, 1.0f, 1.0f, 10.0f);
        }

        @Override
        public void onDrawFrame(GL10 gl) {
            GLES20.glClear(GLES20.GL_DEPTH_BUFFER_BIT | GLES20.GL_COLOR_BUFFER_BIT);

            mCube.drawSelf();
        }
    }
}
