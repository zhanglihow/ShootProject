// Generated by view binder compiler. Do not edit!
package com.tievd.baselib.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.tievd.baselib.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class LayoutActionbarWhiteBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout actionbarLayout;

  @NonNull
  public final ImageView tvBack;

  @NonNull
  public final TextView tvRight;

  @NonNull
  public final TextView tvTitle;

  private LayoutActionbarWhiteBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout actionbarLayout, @NonNull ImageView tvBack,
      @NonNull TextView tvRight, @NonNull TextView tvTitle) {
    this.rootView = rootView;
    this.actionbarLayout = actionbarLayout;
    this.tvBack = tvBack;
    this.tvRight = tvRight;
    this.tvTitle = tvTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static LayoutActionbarWhiteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static LayoutActionbarWhiteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.layout_actionbar_white, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static LayoutActionbarWhiteBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout actionbarLayout = (ConstraintLayout) rootView;

      id = R.id.tv_back;
      ImageView tvBack = ViewBindings.findChildViewById(rootView, id);
      if (tvBack == null) {
        break missingId;
      }

      id = R.id.tv_right;
      TextView tvRight = ViewBindings.findChildViewById(rootView, id);
      if (tvRight == null) {
        break missingId;
      }

      id = R.id.tv_title;
      TextView tvTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvTitle == null) {
        break missingId;
      }

      return new LayoutActionbarWhiteBinding((ConstraintLayout) rootView, actionbarLayout, tvBack,
          tvRight, tvTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
