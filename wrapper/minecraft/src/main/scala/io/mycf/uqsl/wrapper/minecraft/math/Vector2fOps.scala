package io.mycf.uqsl.wrapper.minecraft.math

import net.minecraft.util.math.Vec2f
import net.minecraft.client.util.math.Vector2f
import net.minecraft.util.math.MathHelper.sqrt

import scala.annotation.targetName

object Vector2fOps:
  extension (thiz: Vector2f)

  // Standard math operators
  /**
   * Adds a [[Vector2f]] to a [[Vector2f]].
   */
    @targetName("plus")
    def +(other: Vector2f): Vector2f = {
      Vector2f(
        thiz.getX + other.getX,
        thiz.getY + other.getY
      )
    }

    /**
     * Subtracts a [[Vector2f]] from a [[Vector2f]].
     */
    @targetName("minus")
    def -(other: Vector2f): Vector2f = {
      Vector2f(
        thiz.getX - other.getX,
        thiz.getY - other.getY
      )
    }

    /**
     * Multiplies a [[Vector2f]] and a [[Vector2f]].
     * This method is a shorthand for component wise multiplication.
     */
    @targetName("times")
    def *(other: Vector2f): Vector2f = {
      Vector2f(
        thiz.getX * other.getX,
        thiz.getY * other.getY
      )
    }

    /**
     * Multiplies a [[Vector2f]] and a [[Float]].
     */
    @targetName("times")
    def *(other: Float): Vector2f = {
      Vector2f(
        thiz.getX * other,
        thiz.getY * other
      )
    }

    /**
     * Divides a [[Vector2f]] and a [[Float]].
     */
    @targetName("div")
    def /(other: Float): Vector2f = {
      Vector2f(
        thiz.getX / other,
        thiz.getY / other
      )
    }

    /**
     * Negates a [[Vector2f]].
     */
    @targetName("unaryMinus")
    def -(): Vector2f = {
      thiz * (-1f)
    }


    // Type compatibility operator variations
    /**
     * Adds a [[Vec2f]] to a [[Vector2f]].
     */
    @targetName("plus")
    def +(other: Vec2f): Vector2f = {
      Vector2f(
        thiz.getX + other.x,
        thiz.getY + other.y
      )
    }

    /**
     * Subtracts a [[Vec2f]] from a [[Vector2f]].
     */
    @targetName("minus")
    def -(other: Vec2f): Vector2f = {
      Vector2f(
        thiz.getX - other.x,
        thiz.getY - other.y
      )
    }

    /**
     * Multiplies a [[Vector2f]] and a [[Vec2f]].
     * This method is a shorthand for component wise multiplication.
     */
    @targetName("times")
    def *(other: Vec2f): Vector2f = {
      Vector2f(
        thiz.getX * other.x,
        thiz.getY * other.y
      )
    }


    // Vector specific operators
    /**
     * The dot product of a [[Vector2f]] and a [[Vec2f]].
     */
    def dot(other: Vec2f): Float = {
      thiz.getX * other.x + thiz.getY * other.y
    }

    /**
     * The dot product of a [[Vector2f]] and a [[Vector2f]].
     */
    def dot(other: Vector2f): Float = {
      thiz.getX * other.getX + thiz.getY * other.getY
    }

    /**
     * Returns the normalized form of a [[Vector2f]].
     */
    def normalize(): Vector2f = {
      val len = length()
      if len < EPSILON then
        Vector2f(0f, 0f)
      else
        Vector2f(thiz.getX / len, thiz.getY / len)
    }

    /**
     * The length of a [[Vector2f]].
     */
    def length(): Float = {
      sqrt(thiz.getX * thiz.getX + thiz.getY * thiz.getY)
    }

    /**
     * The length squared of a [[Vector2f]].
     */
    def lengthSquared(): Float = {
      thiz.getX * thiz.getX + thiz.getY * thiz.getY
    }

    /**
     * The [`x`][[Vector2f.x]] component of a [[Vector2f]].
     */
    def component1(): Float = {
      thiz.getX
    }

    /**
     * The [`y`][[Vector2f.y]] component of a [[Vector2f]].
     */
    def component2(): Float = {
      thiz.getY
    }
