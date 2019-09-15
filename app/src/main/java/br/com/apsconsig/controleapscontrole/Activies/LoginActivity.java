package br.com.apsconsig.controleapscontrole.Activies;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import br.com.apsconsig.controleapscontrole.R;
import br.com.apsconsig.controleapscontrole.SplashScreemActivity;
import br.com.apsconsig.controleapscontrole.databinding.ActivityLoginBinding;

import java.sql.DatabaseMetaData;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Iniciações
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        //Animação
        overridePendingTransition(0,0);
        View relativeLayout=findViewById(R.id.login_container);
        Animation animation=AnimationUtils.loadAnimation(this,android.R.anim.fade_in);
        relativeLayout.startAnimation(animation);


    }//Oncreat

    public void entrar(View view) {
        animButtonWidth();
        fadeOutTextSetProgess();
        nextAction();
    }

    private void animButtonWidth(){
        ValueAnimator animator = ValueAnimator.ofInt(binding.btnLogin.getMeasuredWidth(),getFinalWidth());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                int value = (Integer) animation.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = binding.btnLogin.getLayoutParams();
                layoutParams.width = value;
                binding.btnLogin.requestLayout();
            }
        });

        animator.setDuration(250);
        animator.start();

    }

    private void fadeOutTextSetProgess(){
        binding.btnLogin.animate().alpha(0f).setDuration(250).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                showProgessDialog();
            }
        }).start();
    }

    private void showProgessDialog() {
        binding.progressBar.getIndeterminateDrawable().setColorFilter(Color.parseColor("#000000"), PorterDuff.Mode.SRC_IN);
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    private void nextAction(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                revealButton();
                fadeOutProgess();
                delayedStartNextActivity();
            }
        },2000);
    }

    private void revealButton(){

        binding.btnLogin.setElevation(0f);
        binding.revelarView.setVisibility(View.VISIBLE);

        int x = binding.revelarView.getWidth();
        int y = binding.revelarView.getHeight();

        int startX = (int) (getFinalWidth()/ 2 + binding.btnLogin.getX());
        int startY = (int) (getFinalWidth()/ 2 + binding.btnLogin.getY());

        float radius = Math.max(x, y) * 1.2f;

        Animator reveal = ViewAnimationUtils.createCircularReveal(binding.revelarView, startX, startY, getFinalWidth(), radius);
        reveal.setDuration(350);
        reveal.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                finish();
            }
        });
        reveal.start();
    }

    private void fadeOutProgess(){
        binding.progressBar.animate().alpha(0f).setDuration(200).start();
    }

    private void delayedStartNextActivity(){
        boolean b = new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                finish();
            }
        },100);
    }

    private int getFinalWidth(){
        return (int) getResources().getDimension(R.dimen.getWidth);
    }



}//Main
