package ise308.polat.utku.animationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener, Animation.AnimationListener {

    private lateinit var animFadeIn : Animation
    private lateinit var animFadeOut : Animation
    private lateinit var animFadeInOut : Animation
    private lateinit var animZoomIn : Animation
    private lateinit var animZoomOut : Animation
    private lateinit var animLeftRight : Animation
    private lateinit var animRightLeft : Animation
    private lateinit var animTopBottom : Animation
    private lateinit var animBounce : Animation
    private lateinit var animFlash : Animation
    private lateinit var animRotateLeft : Animation
    private lateinit var animRotateRight : Animation

    private lateinit var imageView: View
    private lateinit var textView: TextView

    var seekSpeedProgress : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        textView = findViewById(R.id.textView)

        loadAnimations()

        findViewById<Button>(R.id.btn_fade_in).setOnClickListener(this)
        findViewById<Button>(R.id.btn_fade_out).setOnClickListener(this)
        findViewById<Button>(R.id.btn_fade_in_out).setOnClickListener(this)
        findViewById<Button>(R.id.btn_zoom_in).setOnClickListener(this)
        findViewById<Button>(R.id.btn_zoom_out).setOnClickListener(this)
        findViewById<Button>(R.id.btn_left_right).setOnClickListener(this)
        findViewById<Button>(R.id.btn_right_left).setOnClickListener(this)
        findViewById<Button>(R.id.btn_top_bottom).setOnClickListener(this)
        findViewById<Button>(R.id.btn_flash).setOnClickListener(this)
        findViewById<Button>(R.id.btn_bounce).setOnClickListener(this)
        findViewById<Button>(R.id.btn_rotate_left).setOnClickListener(this)
        findViewById<Button>(R.id.btn_rotate_right).setOnClickListener(this)

        val textViewSeekSpeed = findViewById<TextView>(R.id.textView_seeker_speed)
        val seekBar = findViewById<SeekBar>(R.id.seek_bar_speed)
        seekBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    seekSpeedProgress = progress
                    textViewSeekSpeed.text = ("$seekSpeedProgress of ${seekBar!!.max}")
                }

                override fun onStartTrackingTouch(p0: SeekBar?) {

                }

                override fun onStopTrackingTouch(p0: SeekBar?) {}
            }
        )
    }

    fun loadAnimations() {
        animFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        animFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out)
        animFadeInOut = AnimationUtils.loadAnimation(this, R.anim.fade_in_out)
        animZoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
        animZoomOut = AnimationUtils.loadAnimation(this, R.anim.zoom_out)
        animLeftRight = AnimationUtils.loadAnimation(this, R.anim.left_right)
        animRightLeft = AnimationUtils.loadAnimation(this, R.anim.right_left)
        animTopBottom = AnimationUtils.loadAnimation(this, R.anim.top_bottom)
        animBounce = AnimationUtils.loadAnimation(this, R.anim.bounce)
        animFlash = AnimationUtils.loadAnimation(this, R.anim.flash)
        animRotateLeft = AnimationUtils.loadAnimation(this, R.anim.rotate_left)
        animRotateRight = AnimationUtils.loadAnimation(this, R.anim.rotate_right)

    }

    override fun onClick(v : View) {
        when(v!!.id) {
            R.id.btn_fade_in -> {
                animFadeIn.duration = seekSpeedProgress.toLong()
                animFadeIn.setAnimationListener(this)
                imageView.startAnimation(animFadeIn)
            }
            R.id.btn_fade_out -> {
                animFadeOut.duration = seekSpeedProgress.toLong()
                animFadeOut.setAnimationListener(this)
                imageView.startAnimation(animFadeOut)
            }
            R.id.btn_fade_in_out -> {
                animFadeInOut.duration = seekSpeedProgress.toLong()
                animFadeInOut.setAnimationListener(this)
                imageView.startAnimation(animFadeInOut)
            }
            R.id.btn_zoom_in -> {
                animZoomIn.duration = seekSpeedProgress.toLong()
                animZoomIn.setAnimationListener(this)
                imageView.startAnimation(animZoomIn)
            }
            R.id.btn_zoom_out -> {
                animZoomOut.duration = seekSpeedProgress.toLong()
                animZoomOut.setAnimationListener(this)
                imageView.startAnimation(animZoomOut)
            }
            R.id.btn_left_right -> {
                animLeftRight.duration = seekSpeedProgress.toLong()
                animLeftRight.setAnimationListener(this)
                imageView.startAnimation(animLeftRight)
            }
            R.id.btn_right_left -> {
                animRightLeft.duration = seekSpeedProgress.toLong()
                animRightLeft.setAnimationListener(this)
                imageView.startAnimation(animRightLeft)
            }
            R.id.btn_top_bottom -> {
                animTopBottom.duration = seekSpeedProgress.toLong()
                animTopBottom.setAnimationListener(this)
                imageView.startAnimation(animTopBottom)
            }
            R.id.btn_flash -> {
                animFlash.duration = ((seekSpeedProgress)/10).toLong()
                animFlash.setAnimationListener(this)
                imageView.startAnimation(animFlash)
            }
            R.id.btn_bounce -> {
                animBounce.duration = ((seekSpeedProgress)/10).toLong()
                animBounce.setAnimationListener(this)
                imageView.startAnimation(animBounce)
            }
            R.id.btn_rotate_left -> {
                animRotateLeft.duration = seekSpeedProgress.toLong()
                animRotateLeft.setAnimationListener(this)
                imageView.startAnimation(animRotateLeft)
            }
            R.id.btn_rotate_right -> {
                animRotateRight.duration = seekSpeedProgress.toLong()
                animRotateRight.setAnimationListener(this)
                imageView.startAnimation(animRotateRight)
            }
        }
    }

    override fun onAnimationStart(p0: Animation?) {
        textView.text = "Running"
    }

    override fun onAnimationEnd(p0: Animation?) {
        textView.text = "Stopped"
    }

    override fun onAnimationRepeat(p0: Animation?) {}

}