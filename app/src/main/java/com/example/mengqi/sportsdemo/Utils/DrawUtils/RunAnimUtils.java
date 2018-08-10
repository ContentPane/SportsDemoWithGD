package com.example.mengqi.sportsdemo.Utils.DrawUtils;

import android.animation.Animator;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.RelativeLayout;

public class RunAnimUtils {
    public static void handleAnimate(final View animateView, int centerX, int centerY) {
        // 隐藏
        if (animateView.getVisibility() == View.VISIBLE) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                final Animator animatorHide = ViewAnimationUtils.createCircularReveal(animateView,
                        centerX, centerY, (float) Math.hypot(animateView.getWidth(), animateView.getHeight()), 0);
                animatorHide.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        animateView.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });
                animatorHide.setDuration(500);
                animatorHide.start();
            } else {
                animateView.setVisibility(View.GONE);
            }
            animateView.setEnabled(false);
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                final Animator animator = ViewAnimationUtils.createCircularReveal(animateView,
                        centerX, centerY, 0, (float) Math.hypot(animateView.getWidth(), animateView.getHeight()));
                animator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {
                        animateView.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {

                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });
                animator.setDuration(500);
                animator.start();
            } else {
                animateView.setVisibility(View.VISIBLE);
            }
            animateView.setEnabled(true);
        }
    }
}
