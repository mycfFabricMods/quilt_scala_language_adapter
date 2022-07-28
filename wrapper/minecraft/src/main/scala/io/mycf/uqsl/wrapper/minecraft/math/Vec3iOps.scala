package io.mycf.uqsl.wrapper.minecraft.math

import net.minecraft.client.util.math.Vector3d
import net.minecraft.util.math.{Vec3d, Vec3f, Vec3i}

import scala.annotation.targetName
import scala.math.sqrt

object Vec3iOps:
  extension (thiz: Vec3i)

    def x = thiz.getX
    def y = thiz.getY
    def z = thiz.getZ

    /**
     * Adds a [[Vec3i]] to a [[Vec3i]].
     */
    @targetName("plus")
    def +(other: Vec3i): Vec3i = {
      Vec3i(
        thiz.x + other.x,
        thiz.y + other.y,
        thiz.z + other.z
      )
    }

    /**
     * Subtracts a [[Vec3i]] from a [[Vec3i]].
     */
    @targetName("minus")
    def -(other: Vec3i): Vec3i = {
      Vec3i(
        thiz.x - other.x,
        thiz.y - other.y,
        thiz.z - other.z
      )
    }

    /**
     * Multiplies a [[Vec3i]] and a [[Vec3i]].
     * This method is a shorthand for component wise multiplication.
     */
    @targetName("times")
    def *(other: Vec3i): Vec3i = {
      Vec3i(
        thiz.x * other.x,
        thiz.y * other.y,
        thiz.z * other.z
      )
    }

    /**
     * Multiplies a [[Vec3i]] and an [[Int]].
     */
    @targetName("times")
    def *(other: Int): Vec3i = {
      Vec3i(
        thiz.x * other,
        thiz.y * other,
        thiz.z * other
      )
    }

    /**
     * Divides a [[Vec3i]] and an [[Int]].
     */
    @targetName("div")
    def /(other: Int): Vec3i = {
      Vec3i(
        thiz.x / other,
        thiz.y / other,
        thiz.z / other
      )
    }

    /**
     * Negates a [[Vec3i]].
     */
    @targetName("unaryMinus")
    def -(): Vec3i = {
      thiz * (-1)
    }


    // Type compatibility operator variations
    /**
     * Adds a [[Vec3d]] to a [[Vec3i]].
     */
    @targetName("plus")
    def +(other: Vec3d): Vec3i = {
      Vec3i(
        thiz.x + other.x.toInt,
        thiz.y + other.y.toInt,
        thiz.z + other.z.toInt
      )
    }

    /**
     * Adds a [[Vec3f]] to a [[Vec3i]].
     */
    @targetName("plus")
    def +(other: Vec3f): Vec3i = {
      Vec3i(
        thiz.x + other.getX.toInt,
        thiz.y + other.getY.toInt,
        thiz.z + other.getZ.toInt
      )
    }

    /**
     * Adds a [[Vector3d]] to a [[Vec3i]].
     */
    @targetName("plus")
    def +(other: Vector3d): Vec3i = {
      Vec3i(
        thiz.x + other.x.toInt,
        thiz.y + other.y.toInt,
        thiz.z + other.z.toInt
      )
    }

    /**
     * Subtracts a [[Vec3d]] from a [[Vec3i]].
     */
    @targetName("minus")
    def -(other: Vec3d): Vec3i = {
      Vec3i(
        thiz.x - other.x.toInt,
        thiz.y - other.y.toInt,
        thiz.z - other.z.toInt
      )
    }

    /**
     * Subtracts a [[Vec3f]] from a [[Vec3i]].
     */
    @targetName("minus")
    def -(other: Vec3f): Vec3i = {
      Vec3i(
        thiz.x - other.getX.toInt,
        thiz.y - other.getY.toInt,
        thiz.z - other.getZ.toInt
      )
    }

    /**
     * Subtracts a [[Vector3d]] from a [[Vec3i]].
     */
    @targetName("minus")
    def -(other: Vector3d): Vec3i = {
      Vec3i(
        thiz.x - other.x.toInt,
        thiz.y - other.y.toInt,
        thiz.z - other.z.toInt
      )
    }

    /**
     * Multiplies a [[Vec3i]] and a [[Vec3d]].
     * This method is a shorthand for component wise multiplication.
     */
    @targetName("times")
    def *(other: Vec3d): Vec3i = {
      Vec3i(
        thiz.x * other.x.toInt,
        thiz.y * other.y.toInt,
        thiz.z * other.z.toInt
      )
    }

    /**
     * Multiplies a [[Vec3i]] and a [[Vec3f]].
     * This method is a shorthand for component wise multiplication.
     */
    @targetName("times")
    def *(other: Vec3f): Vec3i = {
      Vec3i(
        thiz.x * other.getX.toInt,
        thiz.y * other.getY.toInt,
        thiz.z * other.getZ.toInt
      )
    }

    /**
     * Multiplies a [[Vec3i]] and a [[Vector3d]].
     * This method is a shorthand for component wise multiplication.
     */
    @targetName("times")
    def *(other: Vector3d): Vec3i = {
      Vec3i(
        thiz.x * other.x.toInt,
        thiz.y * other.y.toInt,
        thiz.z * other.z.toInt
      )
    }


    // Vector specific operators
    /**
     * The dot product of a [[Vec3i]] and a [[Vec3d]].
     */
    def dot(other: Vec3d): Int = {
      thiz.x * other.x.toInt + thiz.y * other.y.toInt + thiz.z * other.z.toInt
    }

    /**
     * The cross product of a [[Vec3i]] and a [[Vec3d]].
     */
    def cross(other: Vec3d): Vec3i = {
      thiz.crossProduct(Vec3i(other.x, other.y, other.z))
    }

    /**
     * The dot product of a [[Vec3i]] and a [[Vec3f]].
     */
    def dot(other: Vec3f): Int = {
      thiz.x * other.getX.toInt + thiz.y * other.getY.toInt + thiz.z * other.getZ.toInt
    }

    /**
     * The cross product of a [[Vec3i]] and a [[Vec3f]].
     */
    def cross(other: Vec3f): Vec3i = {
      thiz.crossProduct(Vec3i(other.getX.toDouble, other.getY.toDouble, other.getZ.toDouble))
    }

    /**
     * The dot product of a [[Vec3i]] and a [[Vec3i]].
     */
    def dot(other: Vec3i): Int = {
      thiz.x * other.x + thiz.y * other.y + thiz.z * other.z
    }

    /**
     * The cross product of a [[Vec3i]] and a [[Vec3i]].
     */
    def cross(other: Vec3i): Vec3i = {
      thiz.crossProduct(other)
    }

    /**
     * The dot product of a [[Vec3i]] and a [[Vector3d]].
     */
    def dot(other: Vector3d): Int = {
      thiz.x * other.x.toInt + thiz.y * other.y.toInt + thiz.z * other.z.toInt
    }

    /**
     * The cross product of a [[Vec3i]] and a [[Vector3d]].
     */
    def cross(other: Vector3d): Vec3i = {
      thiz.crossProduct(Vec3i(other.x, other.y, other.z))
    }

    /**
     * The length of a [[Vec3i]].
     */
    def length(): Double = {
      sqrt((x * x + y * y + z * z).toDouble)
    }

    /**
     * The length squared of a [[Vec3i]].
     */
    def lengthSquared(): Int = {
      x * x + y * y + z * z
    }
