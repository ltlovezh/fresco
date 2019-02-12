/*
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;

/**
 * Common interface for a frame of an animated image.
 */
public interface AnimatedImageFrame {

  /**
   * Disposes the instance. This will free native resources held by this instance. Once called,
   * other methods on this instance may throw. Note, the underlying native resources may not
   * actually be freed until all associated instances {@link AnimatedImage} are disposed or
   * finalized as well.
   */
  void dispose();

  /**
   * Renders the frame to the specified bitmap. The bitmap must have a width and height that is
   * at least as big as the specified width and height and it must be in RGBA_8888 color format.
   * 把当前帧，绘制成width * height的尺寸（当前帧本身的比例可能不是width * height），然后放进bitmap中
   * @param width the width to render to (the image is scaled to this width)
   * @param height the height to render to (the image is scaled to this height)
   * @param bitmap the bitmap to render into
   */
  void renderFrame(int width, int height, Bitmap bitmap);

  /**
   * Gets the duration of the frame.
   *
   * @return the duration of the frame in milliseconds
   */
  int getDurationMs();

  /**
   * Gets the width of the frame.
   *
   * @return the width of the frame
   */
  int getWidth();

  /**
   * Gets the height of the frame.
   *
   * @return the height of the frame
   */
  int getHeight();

  /**
   * Gets the x-offset of the frame relative to the image canvas.
   *
   * @return the x-offset of the frame
   */
  int getXOffset();

  /**
   * Gets the y-offset of the frame relative to the image canvas.
   *
   * @return the y-offset of the frame
   */
  int getYOffset();
}
