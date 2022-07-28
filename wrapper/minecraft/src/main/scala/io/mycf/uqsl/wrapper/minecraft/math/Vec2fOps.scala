package io.mycf.uqsl.wrapper.minecraft.math

import net.minecraft.client.util.math.Vector2f
import net.minecraft.util.math.Vec2f

import scala.annotation.targetName

object Vec2fOps:
  extension (thiz: Vec2f)

  /**
   * Adds a [[Vec2f]] to a [[Vec2f]].
   */
    @targetName("add")
    def +(other: Vec2f): Vec2f = Vec2f(
      thiz.x + other.x,
      thiz.y + other.y
    )

    /**
     * Subtracts a [[Vec2f]] from a [[Vec2f]].
     */
    @targetName("minus")
    def -(other: Vec2f): Vec2f = Vec2f(
      thiz.x - other.x,
      thiz.y - other.y
    )


    /**
     * Multiplies a [[Vec2f]] and a [[Vec2f]].
     * This method is a shorthand for component wise multiplication.
     */
    @targetName("times")
    def *(other: Vec2f): Vec2f = Vec2f(
      thiz.x * other.x,
      thiz.y * other.y
    )


    /**
     * Multiplies a [[Vec2f]] and a Float.
     */
    @targetName("times")
    def *(other: Float): Vec2f = Vec2f(
      thiz.x * other,
      thiz.y * other
    )


    /**
     * Divides a [[Vec2f]] and a Float.
     */
    @targetName("div")
    def /(other: Float): Vec2f = Vec2f(
      thiz.x / other,
      thiz.y / other
    )


    /**
     * Negates a [[Vec2f]].
     */
    @targetName("unaryMinus")
    def -(): Vec2f = thiz * (-1f)

    /**
     * Adds a [[Vector2f]] to a [[Vec2f]].
     */
    @targetName("plus")
    def +(other: Vector2f): Vec2f = Vec2f(
      thiz.x + other.getX,
      thiz.y + other.getY

    )


    /**
     * Subtracts a [[Vector2f]] from a [[Vec2f]].
     */
    @targetName("minus")
    def -(other: Vector2f): Vec2f = Vec2f(
      thiz.x - other.getX,
      thiz.y - other.getY
    )


    /**
     * Multiplies a [[Vec2f]] and a [[Vector2f]].
     * This method is a shorthand for component wise multiplication.
     */
    @targetName("times")
    def *(other: Vector2f): Vec2f = Vec2f(
      thiz.x * other.getX,
      thiz.y * other.getY
    )

    // Vector specific operators
    /**
     * The dot product of a [[Vec2f]] and a [[Vec2f]].
     */
    def dot(other: Vec2f): Float = thiz dot other

    /**
     * The dot product of a [[Vec2f]] and a [[Vector2f]].
     */
    def dot(other: Vector2f): Float = thiz dot Vec2f(other.getX, other.getY)
