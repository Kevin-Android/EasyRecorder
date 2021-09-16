package com.kevin.easyaudiorecord.ui.ar

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.Toast
import com.google.ar.core.Anchor
import com.google.ar.core.HitResult
import com.google.ar.core.Plane
import com.google.ar.sceneform.AnchorNode
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.rendering.Renderable
import com.google.ar.sceneform.ux.ArFragment
import com.google.ar.sceneform.ux.TransformableNode
import com.kevin.easyaudiorecord.R
import com.kevin.easyaudiorecord.databinding.ArActivityBinding


class ArActivity : AppCompatActivity() {

    lateinit var arFragment: ArFragment

    private val binding by lazy {
        ArActivityBinding.inflate(layoutInflater)
    }

    fun start(activity: Activity) {
        if (checkIsSupportedDeviceOrFinish(activity)){
            return
        }
        val intent = Intent(activity, ArActivity::class.java)
        activity.startActivity(intent)
    }

    /**
     * 从不使用函数“checkIsSupportedDeviceOrFinish”
     */
    private fun checkIsSupportedDeviceOrFinish(activity: Activity): Boolean {
        val openGlVersionString =
            (activity.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager)
                .deviceConfigurationInfo
                .glEsVersion
        if (openGlVersionString.toDouble() < MIN_OPENGL_VERSION) {
            Toast.makeText(activity, "Sceneform 需要 OpenGL ES 3.0 或更高版本", Toast.LENGTH_LONG)
                .show()
            return false
        }
        return true
    }

    companion object {
        private const val MIN_OPENGL_VERSION = 3.0
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val type = intent.getIntExtra("type", 0)
        arFragment = supportFragmentManager.findFragmentById(R.id.ar_fragment) as ArFragment
        arFragment.setOnTapArPlaneListener { hitresult: HitResult, plane: Plane, _: MotionEvent? ->
            if (plane.type != Plane.Type.HORIZONTAL_UPWARD_FACING)
                return@setOnTapArPlaneListener
            val anchor = hitresult.createAnchor()
            when (type) {
                0 -> placeObject(arFragment, anchor, R.raw.prayingmantis)
                1 -> placeObject(arFragment, anchor, R.raw.example1)
                2 -> placeObject(arFragment, anchor, R.raw.example2)
            }
        }
    }

    private fun placeObject(arFragment: ArFragment, anchor: Anchor, uri: Int) {
        ModelRenderable.builder()
            .setSource(arFragment.context, uri)
            .build()
            .thenAccept { modelRenewable: ModelRenderable ->
                addNodeToScene(arFragment, anchor, modelRenewable)
            }
            .exceptionally { throwable: Throwable ->
                Log.i("placeObject", "Error:$throwable.message")
                Toast.makeText(arFragment.context, "Error:$throwable.message", Toast.LENGTH_LONG)
                    .show();
                return@exceptionally null
            }
    }

    private fun addNodeToScene(arFragment: ArFragment, anchor: Anchor, renewable: Renderable) {
        val anchorNode = AnchorNode(anchor)
        val node = TransformableNode(arFragment.transformationSystem)
        node.renderable = renewable
        node.setParent(anchorNode)
        arFragment.arSceneView.scene.addChild(anchorNode)
        node.select()
    }


}