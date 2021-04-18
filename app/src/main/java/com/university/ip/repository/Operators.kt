package com.university.ip.repository

import android.graphics.Bitmap
import org.opencv.android.Utils
import org.opencv.core.CvType
import org.opencv.core.Mat
import org.opencv.imgproc.Imgproc

class Operators {
    fun increaseBrightness(bitmap: Bitmap, value: Int): Bitmap {
        val src = Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC1)
        Utils.bitmapToMat(bitmap, src)
        src.convertTo(src, -1, 1.0, value.toDouble())
        val result = Bitmap.createBitmap(src.cols(), src.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(src, result)
        return result
    }

    fun increaseContrast(bitmap: Bitmap, value: Int): Bitmap {
        val src = Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC1)
        Utils.bitmapToMat(bitmap, src)
        src.convertTo(src, -1, value.toDouble(), 1.0)
        val result = Bitmap.createBitmap(src.cols(), src.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(src, result)
        return result
    }

    fun convertToGrayscale(bitmap: Bitmap): Bitmap {
        val src = Mat(bitmap.getHeight(), bitmap.getWidth(), CvType.CV_8UC1)
        Utils.bitmapToMat(bitmap, src)

        Imgproc.cvtColor(src, src, Imgproc.COLOR_RGB2GRAY);
        Imgproc.cvtColor(src, src, Imgproc.COLOR_GRAY2RGB, 4);

        val result = Bitmap.createBitmap(src.cols(), src.rows(), Bitmap.Config.ARGB_8888)
        Utils.matToBitmap(src, result)
        return result
    }
}