package io.mycf.uqsl.wrapper.minecraft.math

import net.minecraft.util.math.Vec3d
import net.minecraft.util.math.Vec3f
import net.minecraft.util.math.Vec3i
import net.minecraft.client.util.math.Vector3d
import net.minecraft.util.math.MathHelper.sqrt

import scala.annotation.targetName

object Vec3fOps:
  extension (thiz: Vec3f)
  //Standard math operators
  /**
   * Adds a [[Vec3f]] to a [[Vec3f]].
   */
    @targetName("plus")
    def +(other: Vec3f): Vec3f = Vec3f(
      thiz.getX + other.getX,
      thiz.getY + other.getY,
      thiz.getZ + other.getZ
    )

    /**
     * Subtracts a [[Vec3f]] from a [[Vec3f]].
     */
    @targetName("minus")
    def -(other: Vec3f): Vec3f = Vec3f(
      thiz.getX - other.getX,
      thiz.getY - other.getY,
      thiz.getZ - other.getZ
    )


    /**
     * Multiplies a [[Vec3f]] and a [[Vec3f]].
     * thiz method is a shorthand for component wise multiplication.
     */
    @targetName("times")
    def *(other: Vec3f): Vec3f = Vec3f(
      thiz.getX * other.getX,
      thiz.getY * other.getY,
      thiz.getZ * other.getZ
    )


    /**
     * Multiplies a [[Vec3f]] and a [[Float]].
     */
    @targetName("times")
    def *(other: Float): Vec3f = Vec3f(
      thiz.getX * other,
      thiz.getY * other,
      thiz.getZ * other
    )

    /**
     * Divides a [[Vec3f]] and a [[Float]].
     */
    @targetName("div")
    def /(other: Float): Vec3f = Vec3f(
      thiz.getX / other,
      thiz.getY / other,
      thiz.getZ / other
    )


    /**
     * Negates a [[Vec3f]].
     */
    @targetName("unaryMinus")
    def -(): Vec3f = thiz * (-1f)

    //region Type compatibility operator variations
    /**
     * Adds a [[Vec3d]] to a [[Vec3f]].
     */
    @targetName("plus")
    def +(other: Vec3d): Vec3f = Vec3f(
      thiz.getX + other.getX.toFloat,
      thiz.getY + other.getY.toFloat,
      thiz.getZ + other.getZ.toFloat
    )


    /**
     * Adds a [[Vec3i]] to a [[Vec3f]].
     */
    @targetName("plus")
    def +(other: Vec3i): Vec3f = Vec3f(
      thiz.getX + other.getX.toFloat,
      thiz.getY + other.getY.toFloat,
      thiz.getZ + other.getZ.toFloat
    )


    /**
     * Adds a [[Vector3d]] to a [[Vec3f]].
     */
    @targetName("plus")
    def +(other: Vector3d): Vec3f = Vec3f(
      thiz.getX + other.x.toFloat,
      thiz.getY + other.y.toFloat,
      thiz.getZ + other.z.toFloat
    )


    /**
     * Subtracts a [[Vec3d]] from a [[Vec3f]].
     */
    @targetName("minus")
    def -(other: Vec3d): Vec3f = Vec3f(
      thiz.getX - other.getX.toFloat,
      thiz.getY - other.getY.toFloat,
      thiz.getZ - other.getZ.toFloat
    )


    /**
     * Subtracts a [[Vec3i]] from a [[Vec3f]].
     */
    @targetName("minus")
    def -(other: Vec3i): Vec3f = Vec3f(
      thiz.getX - other.getX.toFloat,
      thiz.getY - other.getY.toFloat,
      thiz.getZ - other.getZ.toFloat
    )


    /**
     * Subtracts a [[Vector3d]] from a [[Vec3f]].
     */
    @targetName("minus")
    def -(other: Vector3d): Vec3f = Vec3f(
      thiz.getX - other.x.toFloat,
      thiz.getY - other.y.toFloat,
      thiz.getZ - other.z.toFloat
    )


    /**
     * Multiplies a [[Vec3f]] and a [[Vec3d]].
     * thiz method is a shorthand for component wise multiplication.
     */
    @targetName("times")
    def *(other: Vec3d): Vec3f = Vec3f(
      thiz.getX * other.getX.toFloat,
      thiz.getY * other.getY.toFloat,
      thiz.getZ * other.getZ.toFloat
    )


    /**
     * Multiplies a [[Vec3f]] and a [[Vec3i]].
     * thiz method is a shorthand for component wise multiplication.
     */
    @targetName("times")
    def *(other: Vec3i): Vec3f = Vec3f(
      thiz.getX * other.getX.toFloat,
      thiz.getY * other.getY.toFloat,
      thiz.getZ * other.getZ.toFloat
    )


    /**
     * Multiplies a [[Vec3f]] and a [[Vector3d]].
     * thiz method is a shorthand for component wise multiplication.
     */
    @targetName("times")
    def *(other: Vector3d): Vec3f = {
      Vec3f(
        thiz.getX * other.x.toFloat,
        thiz.getY * other.y.toFloat,
        thiz.getZ * other.z.toFloat
      )
    }

    //region Vector specific operators
    /**
     * The dot product of a [[Vec3f]] and a [[Vec3d]].
     */
    def dot(other: Vec3d): Float = thiz dot Vec3f(other)

    /**
     * The cross product of a [[Vec3f]] and a [[Vec3d]].
     */
    def cross(other: Vec3d): Vec3f = Vec3f(
      (thiz.getY * other.getZ - thiz.getZ * other.getY).toFloat,
      (thiz.getZ * other.getX - thiz.getX * other.getZ).toFloat,
      (thiz.getX * other.getY - thiz.getY * other.getX).toFloat
    )


    /**
     * The dot product of a [[Vec3f]] and a [[Vec3f]].
     */
    def dot(other: Vec3f): Float = thiz dot (other)

    /**
     * The cross product of a [[Vec3f]] and a [[Vec3f]].
     */
    def cross(other: Vec3f): Vec3f = Vec3f(
      thiz.getY * other.getZ - thiz.getZ * other.getY,
      thiz.getZ * other.getX - thiz.getX * other.getZ,
      thiz.getX * other.getY - thiz.getY * other.getX
    )


    /**
     * The dot product of a [[Vec3f]] and a [[Vec3i]].
     */
    def dot(other: Vec3i): Float = thiz.dot(Vec3f(other.getX.toFloat, other.getY.toFloat, other.getZ.toFloat))

    /**
     * The cross product of a [[Vec3f]] and a [[Vec3i]].
     */
    def cross(other: Vec3i): Vec3f = Vec3f(
      thiz.getY * other.getZ - thiz.getZ * other.getY,
      thiz.getZ * other.getX - thiz.getX * other.getZ,
      thiz.getX * other.getY - thiz.getY * other.getX
    )


    /**
     * The dot product of a [[Vec3f]] and a [[Vector3d]].
     */
    def dot(other: Vector3d): Float = thiz.dot(Vec3f(other.x.toFloat, other.y.toFloat, other.z.toFloat))

    /**
     * The cross product of a [[Vec3f]] and a [[Vector3d]].
     */
    def cross(other: Vector3d): Vec3f = Vec3f(
      (thiz.getY * other.z - thiz.getZ * other.y).toFloat,
      (thiz.getZ * other.x - thiz.getX * other.z).toFloat,
      (thiz.getX * other.y - thiz.getY * other.x).toFloat
    )


    /**
     * The length of a [[Vec3f]].
     */
    def length(): Float = {
      val x = thiz.getX
      val y = thiz.getY
      val z = thiz.getZ
      sqrt(x * x + y * y + z * z)
    }

    /**
     * The length squared of a [[Vec3f]].
     */
    def lengthSquared(): Float = {
      val x = thiz.getX
      val y = thiz.getY
      val z = thiz.getZ
      x * x + y * y + z * z
    }

