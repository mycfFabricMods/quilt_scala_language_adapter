package io.mycf.uqsl.wrapper.minecraft.math

import net.minecraft.util.math.Vec3d
import net.minecraft.util.math.Vec3f
import net.minecraft.util.math.Vec3i
import net.minecraft.client.util.math.Vector3d

import scala.annotation.targetName

object Vec3dOps:
  extension (thiz: Vec3d)
  // Standard math operators
  /**
   * Adds a [Vec3d] to a [Vec3d].
   */
    @targetName("plus")
    def +(other: Vec3d): Vec3d = {
      Vec3d(
        thiz.x + other.x,
        thiz.y + other.y,
        thiz.z + other.z
      )
    }

  /**
  * Subtracts a [Vec3d] from a [Vec3d].
  */
    @targetName("minus")
    def -(other: Vec3d): Vec3d = {
      Vec3d(
        thiz.x - other.x,
        thiz.y - other.y,
        thiz.z - other.z
      )
    }

  /**
  * Multiplies a [Vec3d] and a [Vec3d].
  * thiz method is a shorthand for component wise multiplication.
  */
    @targetName("times")
    def *(other: Vec3d): Vec3d = {
      Vec3d(
        thiz.x * other.x,
        thiz.y * other.y,
        thiz.z * other.z
      )
    }

  /**
  * Multiplies a [Vec3d] and a Double.
  */
    @targetName("times")
    def *(other: Double): Vec3d = {
      Vec3d(
        thiz.x * other,
        thiz.y * other,
        thiz.z * other
      )
    }

  /**
  * Divides a [Vec3d] and a Double.
  */
    @targetName("div")
    def /(other: Double): Vec3d = {
      Vec3d(
        thiz.x / other,
        thiz.y / other,
        thiz.z / other
      )
    }

  /**
  * Negates a [Vec3d].
  */

    @targetName("unaryMinus")
    def -(): Vec3d = {
      thiz * (-1.0)
    }

    // Type compatibility operator variations
  /**
  * Adds a [Vec3f] to a [Vec3d].
  */
    @targetName("plus")
    def +(other: Vec3f): Vec3d = {
      Vec3d(
        thiz.x + other.getX.toDouble,
        thiz.y + other.getY.toDouble,
        thiz.z + other.getZ.toDouble
      )
    }

  /**
  * Adds a [Vec3i] to a [Vec3d].
  */
    @targetName("plus")
    def +(other: Vec3i): Vec3d = {
      Vec3d(
        thiz.x + other.getX.toDouble,
        thiz.y + other.getY.toDouble,
        thiz.z + other.getZ.toDouble
      )
    }

  /**
  * Adds a [Vector3d] to a [Vec3d].
  */
    @targetName("plus")
    def +(other: Vector3d): Vec3d = {
      Vec3d(
        thiz.x + other.x,
        thiz.y + other.y,
        thiz.z + other.z
      )
    }

  /**
  * Subtracts a [Vec3f] from a [Vec3d].
  */
    @targetName("minus")
    def -(other: Vec3f): Vec3d = {
      Vec3d(
        thiz.x - other.getX.toDouble,
        thiz.y - other.getY.toDouble,
        thiz.z - other.getZ.toDouble
      )
    }

  /**
  * Subtracts a [Vec3i] from a [Vec3d].
  */
    @targetName("minus")
    def -(other: Vec3i): Vec3d = {
      Vec3d(
        thiz.x - other.getX.toDouble,
        thiz.y - other.getY.toDouble,
        thiz.z - other.getZ.toDouble
      )
    }

  /**
  * Subtracts a [Vector3d] from a [Vec3d].
  */
    @targetName("minus")
    def -(other: Vector3d): Vec3d = {
      Vec3d(
        thiz.x - other.x,
        thiz.y - other.y,
        thiz.z - other.z
      )
    }

  /**
  * Multiplies a [Vec3d] and a [Vec3f].
  * thiz method is a shorthand for component wise multiplication.
  */
    @targetName("times")
    def *(other: Vec3f): Vec3d = {
      Vec3d(
        thiz.x * other.getX.toDouble,
        thiz.y * other.getY.toDouble,
        thiz.z * other.getZ.toDouble
      )
    }

  /**
  * Multiplies a [Vec3d] and a [Vec3i].
  * thiz method is a shorthand for component wise multiplication.
  */
    @targetName("times")
    def *(other: Vec3i): Vec3d = {
      Vec3d(
        thiz.x * other.getX.toDouble,
        thiz.y * other.getY.toDouble,
        thiz.z * other.getZ.toDouble
      )
    }

  /**
  * Multiplies a [Vec3d] and a [Vector3d].
  * thiz method is a shorthand for component wise multiplication.
  */
    @targetName("times")
    def *(other: Vector3d): Vec3d = {
      Vec3d(
        thiz.x * other.x,
        thiz.y * other.y,
        thiz.z * other.z
      )
    }


    // Vector specific operators
  /**
  * The dot product of a [Vec3d] and a [Vec3d].
  */
    def dot(other: Vec3d): Double = {
      thiz.dotProduct(other)
    }

  /**
  * The cross product of a [Vec3d] and a [Vec3d].
  */
    def cross(other: Vec3d): Vec3d = {
      thiz.crossProduct(other)
    }

  /**
  * The dot product of a [Vec3d] and a [Vec3f].
  */
    def dot(other: Vec3f): Double = {
      thiz.dotProduct(Vec3d(other))
    }

  /**
  * The cross product of a [Vec3d] and a [Vec3f].
  */
    def cross(other: Vec3f): Vec3d = {
      thiz.crossProduct(Vec3d(other))
    }

  /**
  * The dot product of a [Vec3d] and a [Vec3i].
  */
    def dot(other: Vec3i): Double = {
      thiz.dotProduct(Vec3d.of(other))
    }

  /**
  * The cross product of a [Vec3d] and a [Vec3i].
  */
    def cross(other: Vec3i): Vec3d = {
      thiz.crossProduct(Vec3d.of(other))
    }

  /**
  * The dot product of a [Vec3d] and a [Vector3d].
  */
    def dot(other: Vector3d): Double = {
      thiz.dotProduct(Vec3d(other.x, other.y, other.z))
    }

  /**
  * The cross product of a [Vec3d] and a [Vector3d].
  */
    def cross(other: Vector3d): Vec3d = {
      thiz.crossProduct(Vec3d(other.x, other.y, other.z))
    }

  /**
  * The [`x`][x] component of a [Vec3d].
  */
    def component1(): Double = {
      thiz.x
    }

  /**
  * The [`y`][y] component of a [Vec3d].
  */
    def component2(): Double = {
      thiz.y
    }

  /**
  * The [`z`][z] component of a [Vec3d].
  */
    def component3(): Double = {
      thiz.z
    }

