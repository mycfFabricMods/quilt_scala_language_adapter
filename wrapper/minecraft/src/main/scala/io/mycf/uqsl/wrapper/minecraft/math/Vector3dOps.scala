package io.mycf.uqsl.wrapper.minecraft.math

import net.minecraft.util.math.Vec3d
import net.minecraft.util.math.Vec3f
import net.minecraft.util.math.Vec3i
import net.minecraft.client.util.math.Vector3d

import scala.annotation.targetName
import scala.math.sqrt

object Vector3dOps:
  extension (thiz: Vector3d)

  // Standard math operators
  /**
   * Adds a [[Vector3d]] to a [[Vector3d]].
   */
    @targetName("plus")
    def +(other: Vector3d): Vector3d = {
      Vector3d(
        thiz.x + other.x,
        thiz.y + other.y,
        thiz.z + other.z
      )
    }

    /**
     * Subtracts a [[Vector3d]] from a [[Vector3d]].
     */
    @targetName("minus")
    def -(other: Vector3d): Vector3d = {
      Vector3d(
        thiz.x - other.x,
        thiz.y - other.y,
        thiz.z - other.z
      )
    }

    /**
     * Multiplies a [[Vector3d]] and a [[Vector3d]].
     * This method is a shorthand for component wise multiplication.
     */
    @targetName("times")
    def *(other: Vector3d): Vector3d = {
      Vector3d(
        thiz.x * other.x,
        thiz.y * other.y,
        thiz.z * other.z
      )
    }

    /**
     * Multiplies a [[Vector3d]] and a Double.
     */
    @targetName("times")
    def *(other: Double): Vector3d = {
      Vector3d(
        thiz.x * other,
        thiz.y * other,
        thiz.z * other
      )
    }

    /**
     * Divides a [[Vector3d]] and a Double.
     */
    @targetName("div")
    def /(other: Double): Vector3d = {
      Vector3d(
        thiz.x / other,
        thiz.y / other,
        thiz.z / other
      )
    }

    /**
     * Negates a [[Vector3d]].
     */
    @targetName("unaryMinus")
    def -(): Vector3d = {
      thiz * (-1.0)
    }


    // Type compatibility operator variations
    /**
     * Adds a [[Vec3d]] to a [[Vector3d]].
     */
    @targetName("plus")
    def +(other: Vec3d): Vector3d = {
      Vector3d(
        thiz.x + other.x,
        thiz.y + other.y,
        thiz.z + other.z
      )
    }

    /**
     * Adds a [[Vec3f]] to a [[Vector3d]].
     */
    @targetName("plus")
    def +(other: Vec3f): Vector3d = {
      Vector3d(
        thiz.x + other.getX.toDouble,
        thiz.y + other.getY.toDouble,
        thiz.z + other.getZ.toDouble
      )
    }

    /**
     * Adds a [[Vec3i]] to a [[Vector3d]].
     */
    @targetName("plus")
    def +(other: Vec3i): Vector3d = {
      Vector3d(
        thiz.x + other.getX.toDouble,
        thiz.y + other.getY.toDouble,
        thiz.z + other.getZ.toDouble
      )
    }

    /**
     * Subtracts a [[Vec3d]] from a [[Vector3d]].
     */
    @targetName("minus")
    def -(other: Vec3d): Vector3d = {
      Vector3d(
        thiz.x - other.x,
        thiz.y - other.y,
        thiz.z - other.z
      )
    }

    /**
     * Subtracts a [[Vec3f]] from a [[Vector3d]].
     */
    @targetName("minus")
    def -(other: Vec3f): Vector3d = {
      Vector3d(
        thiz.x - other.getX.toDouble,
        thiz.y - other.getY.toDouble,
        thiz.z - other.getZ.toDouble
      )
    }

    /**
     * Subtracts a [[Vec3i]] from a [[Vector3d]].
     */
    @targetName("minus")
    def -(other: Vec3i): Vector3d = {
      Vector3d(
        thiz.x - other.getX.toDouble,
        thiz.y - other.getY.toDouble,
        thiz.z - other.getZ.toDouble
      )
    }

    /**
     * Multiplies a [[Vector3d]] and a [[Vec3d]].
     * This method is a shorthand for component wise multiplication.
     */
    @targetName("times")
    def *(other: Vec3d): Vector3d = {
      Vector3d(
        thiz.x * other.getX,
        thiz.y * other.getY,
        thiz.z * other.getZ
      )
    }

    /**
     * Multiplies a [[Vector3d]] and a [[Vec3f]].
     * This method is a shorthand for component wise multiplication.
     */
    @targetName("times")
    def *(other: Vec3f): Vector3d = {
      Vector3d(
        thiz.x * other.getX.toDouble,
        thiz.y * other.getY.toDouble,
        thiz.z * other.getZ.toDouble
      )
    }

    /**
     * Multiplies a [[Vector3d]] and a [[Vec3i]].
     * This method is a shorthand for component wise multiplication.
     */
    @targetName("times")
    def *(other: Vec3i): Vector3d = {
      Vector3d(
        thiz.x * other.getX.toDouble,
        thiz.y * other.getY.toDouble,
        thiz.z * other.getZ.toDouble
      )
    }

    // Vector specific operators
    /**
     * The dot product of a [[Vector3d]] and a [[Vec3d]].
     */
    def dot(other: Vec3d): Double = {
      thiz.x * other.x + thiz.y * other.y + thiz.z * other.z
    }

    /**
     * The cross product of a [[Vector3d]] and a [[Vec3d]].
     */
    def cross(other: Vec3d): Vector3d = {
      Vector3d(
        thiz.y * other.z - thiz.z * other.y,
        thiz.z * other.x - thiz.x * other.z,
        thiz.x * other.y - thiz.y * other.x
      )
    }

    /**
     * The dot product of a [[Vector3d]] and a [[Vec3f]].
     */
    def dot(other: Vec3f): Double = {
      thiz.x * other.getX + thiz.y * other.getY + thiz.z * other.getZ
    }

    /**
     * The cross product of a [[Vector3d]] and a [[Vec3f]].
     */
    def cross(other: Vec3f): Vector3d = {
      Vector3d(
        thiz.y * other.getZ - thiz.z * other.getY,
        thiz.z * other.getX - thiz.x * other.getZ,
        thiz.x * other.getY - thiz.y * other.getX
      )
    }

    /**
     * The dot product of a [[Vector3d]] and a [[Vec3i]].
     */
    def dot(other: Vec3i): Double = {
      thiz.x * other.getX + thiz.y * other.getY + thiz.z * other.getZ
    }

    /**
     * The cross product of a [[Vector3d]] and a [[Vec3i]].
     */
    def cross(other: Vec3i): Vector3d = {
      Vector3d(
        thiz.y * other.getZ - thiz.z * other.getY,
        thiz.z * other.getX - thiz.x * other.getZ,
        thiz.x * other.getY - thiz.y * other.getX
      )
    }

    /**
     * The dot product of a [[Vector3d]] and a [[Vector3d]].
     */
    def dot(other: Vector3d): Double = {
      thiz.x * other.x + thiz.y * other.y + thiz.z * other.z
    }

    /**
     * The cross product of a [[Vector3d]] and a [[Vector3d]].
     */
    def cross(other: Vector3d): Vector3d = {
      Vector3d(
        thiz.y * other.z - thiz.z * other.y,
        thiz.z * other.x - thiz.x * other.z,
        thiz.x * other.y - thiz.y * other.x
      )
    }

    /**
     * Returns the normalized form of a [[Vector3d]].
     */
    def normalize(): Vector3d = {
      val len = length()
      if len < EPSILON then
        Vector3d(0.0, 0.0, 0.0)
      else
        Vector3d(thiz.x / len, thiz.y / len, thiz.z / len)
    }

    /**
     * The length of a [[Vector3d]].
     */
    def length(): Double = {
      sqrt(thiz.x * thiz.x + thiz.y * thiz.y + thiz.z * thiz.z)
    }

    /**
     * The length squared of a [[Vector3d]].
     */
    def lengthSquared(): Double = {
      thiz.x * thiz.x + thiz.y * thiz.y + thiz.z * thiz.z
    }

    /**
     * The [`x`][[Vector3d.x]] component of a [[Vector3d]].
     */
    def component1(): Double = {
      thiz.x
    }

    /**
     * The [`y`][[Vector3d.y]] component of a [[Vector3d]].
     */
    def component2(): Double = {
      thiz.y
    }

    /**
     * The [`z`][[Vector3d.z]] component of a [[Vector3d]].
     */
    def component3(): Double = {
      thiz.z
    }

