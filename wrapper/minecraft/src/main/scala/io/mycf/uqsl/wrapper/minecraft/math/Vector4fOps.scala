package io.mycf.uqsl.wrapper.minecraft.math

import net.minecraft.util.math.MathHelper
import net.minecraft.util.math.Vector4f

import scala.annotation.targetName

object Vector4fOps:
  extension (thiz: Vector4f)

  //Standard math operators

  /**
   * Adds a [[Vector4f]] to a [[Vector4f]].
   */
    @targetName("plus")
    def +(other: Vector4f): Vector4f = {
      Vector4f(
        thiz.getX + other.getX,
        thiz.getY + other.getY,
        thiz.getZ + other.getZ,
        thiz.getW + other.getW
      )
    }

    /**
     * Subtracts a [[Vector4f]] from a [[Vector4f]].
     */
    @targetName("minus")
    def -(other: Vector4f): Vector4f = {
      Vector4f(
        thiz.getX - other.getX,
        thiz.getY - other.getY,
        thiz.getZ - other.getZ,
        thiz.getW - other.getW
      )
    }

    /**
     * Multiplies a [[Vector4f]] and a [[Vector4f]].
     * This method is a shorthand for component wise multiplication.
     */
    @targetName("times")
    def *(other: Vector4f): Vector4f = {
      Vector4f(
        thiz.getX * other.getX,
        thiz.getY * other.getY,
        thiz.getZ * other.getZ,
        thiz.getW * other.getW
      )
    }

    /**
     * Multiplies a [[Vector4f]] and a [[Float]].
     */
    @targetName("times")
    def *(other: Float): Vector4f = {
      Vector4f(
        thiz.getX * other,
        thiz.getY * other,
        thiz.getZ * other,
        thiz.getW * other
      )
    }

    /**
     * Divides a [[Vector4f]] and a [[Float]].
     */
    @targetName("div")
    def /(other: Float): Vector4f = {
      Vector4f(
        thiz.getX / other,
        thiz.getY / other,
        thiz.getZ / other,
        thiz.getW / other
      )
    }

    /**
     * Negates a [[Vector4f]].
     */
    def unaryMinus(): Vector4f = {
      thiz * (-1f)
    }

    // Vector specific operators
    /**
     * The dot product of a [[Vector4f]] and a [[Vector4f]].
     */
    def dot(other: Vector4f): Float = {
      thiz.dotProduct(other)
    }

    /**
     * Returns the normalized form of a [[Vector4f]].
     *
     * Must break convention here and name thiz `normalized` instead of `normalize`
     * because normalize() is an existing, mutating function.
     */
    def normalized(): Vector4f = {
      val len = length()
      if len < EPSILON then
        Vector4f(0f, 0f, 0f, 0f)
      else
        Vector4f(thiz.getX / len, thiz.getY / len, thiz.getZ / len, thiz.getW / len)
    }

    /**
     * The length of a [[Vector4f]].
     */
    def length(): Float = {
      MathHelper.sqrt(thiz.getX * thiz.getX + thiz.getY * thiz.getY + thiz.getZ * thiz.getZ + thiz.getW * thiz.getW)
    }

    /**
     * The length squared of a [[Vector4f]].
     */
    def lengthSquared(): Float = {
      thiz.getX * thiz.getX + thiz.getY * thiz.getY + thiz.getZ * thiz.getZ + thiz.getW * thiz.getW
    }

    /**
     * The [`x`][[Vector4f.x]] component of a [[Vector4f]].
     */
    def component1(): Float = {
      thiz.getX
    }

    /**
     * The [`y`][[Vector4f.z]] component of a [[Vector4f]].
     */
    def component2(): Float = {
      thiz.getY
    }

    /**
     * The [`z`][[Vector4f.z]] component of a [[Vector4f]].
     */
    def component3(): Float = {
      thiz.getZ
    }

    /**
     * The [`w`][[Vector4f.w]] component of a [[Vector4f]].
     */
    def component4(): Float = {
      thiz.getW
    }
