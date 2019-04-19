package com.skydoves.waterdays.compose;

import android.os.Bundle;

import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.skydoves.waterdays.WDApplication;
import com.skydoves.waterdays.compose.qualifiers.RequirePresenter;
import com.skydoves.waterdays.utils.BundleUtils;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * Developed by skydoves on 2017-08-19.
 * Copyright (c) 2017 skydoves rights reserved.
 */

public abstract class BaseActivity<Presenter extends BasePresenter, ViewType extends BaseView> extends RxAppCompatActivity {

  private static final String PRESENTER_KEY = "presenter";
  protected Presenter presenter;
  protected ViewType baseView;

  /**
   * get presenter
   *
   * @return presenter
   */
  public Presenter presenter() {
    return presenter;
  }

  /**
   * get baseView
   *
   * @return baseView
   */
  public ViewType baseView() {
    return baseView;
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public void setContentView(@LayoutRes int layoutResID) {
    super.setContentView(layoutResID);
  }

  @Override
  protected void onStart() {
    super.onStart();
  }

  @Override
  protected void onResume() {
    super.onResume();
  }

  @Override
  protected void onPause() {
    super.onPause();
  }

  @Override
  protected void onStop() {
    super.onStop();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();

    if (isFinishing()) {
      if (this.presenter != null) {
        ActivityPresenterManager.Companion.getInstance().destroy(this.presenter);
        this.presenter = null;
      }
    }
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);

    final Bundle presenterEnvelope = new Bundle();
    if (this.presenter != null) {
      ActivityPresenterManager.Companion.getInstance().save(this.presenter, presenterEnvelope);
    }
  }

  /**
   * get WDApplication
   *
   * @return {@link WDApplication} instance
   */
  protected @NonNull
  WDApplication application() {
    return (WDApplication) getApplication();
  }

  /**
   * triggers a back press
   */
  public void goBack() {
    super.onBackPressed();
  }

  /**
   * initialize baseView on presenter
   *
   * @param viewType baseView
   */
  @CallSuper
  protected void initBaseView(ViewType viewType) {
    this.baseView = viewType;

    if (baseView != null) {
      assignPresenter(null);
      this.baseView.initializeUI();
    } else
      throw new NullPointerException();
  }

  /**
   * initialize presenter
   *
   * @param presenterEnvelope bundle
   */
  @SuppressWarnings("unchecked")
  private void assignPresenter(final @Nullable Bundle presenterEnvelope) {
    if (this.presenter == null) {
      final RequirePresenter annotation = getClass().getAnnotation(RequirePresenter.class);
      final Class<Presenter> presenterClass = annotation == null ? null : (Class<Presenter>) annotation.value();
      if (presenterClass != null) {
        this.presenter = ActivityPresenterManager.Companion.getInstance().fetch(this,
            presenterClass,
            BundleUtils.INSTANCE.maybeGetBundle(presenterEnvelope, PRESENTER_KEY));
        this.presenter.setBaseView(baseView);
      }
    }
  }
}