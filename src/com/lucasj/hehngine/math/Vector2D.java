package com.lucasj.hehngine.math;

public class Vector2D {
    private double x;
    private double y;

    /***
     * Creates a 2D vector with default values (0, 0)
     */
    public Vector2D() {
    	this.x = 0;
    	this.y = 0;
    }
    
    /***
     * Creates a 2D vector with n values (n, n)
     */
    public Vector2D(double n) {
    	this.x = n;
    	this.y = n;
    }

    /***
     * Creates a 2D vector with x and y values (x, y)
     */
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getters and Setters
    public double getX() {
        return x;
    }
    
    public int getXint() {
        return (int) x;
    }

    public void setX(double x) {
        this.x = x;
    }
    
    public void addX(double x) {
    	this.x += x;
    }

    public double getY() {
        return y;
    }
    
    public int getYint() {
        return (int) y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public void addY(double y) {
    	this.y += y;
    }

    // Add two vectors
    public Vector2D add(Vector2D v) {
        return new Vector2D(this.x + v.x, this.y + v.y);
    }

    // Subtract two vectors
    public Vector2D subtract(Vector2D v) {
        return new Vector2D(this.x - v.x, this.y - v.y);
    }

    // Multiply vector by a scalar
    public Vector2D multiply(double scalar) {
        return new Vector2D(this.x * scalar, this.y * scalar);
    }

    // Divide vector by a scalar
    public Vector2D divide(double scalar) {
        if (scalar != 0) {
            return new Vector2D(this.x / scalar, this.y / scalar);
        } else {
            throw new ArithmeticException("Division by zero is not allowed");
        }
    }

    // Calculate the magnitude (length) of the vector
    public double magnitude() {
        return Math.sqrt(x * x + y * y);
    }

    // Normalize the vector (make it a unit vector)
    public Vector2D normalize() {
        double mag = magnitude();
        if (mag != 0) {
            return divide(mag);
        }
        return new Vector2D(0, 0);  // Return a zero vector if magnitude is 0
    }

    // Calculate the distance between two vectors
    public double distanceTo(Vector2D v) {
        return Math.sqrt(Math.pow(v.x - this.x, 2) + Math.pow(v.y - this.y, 2));
    }

    // Dot product between two vectors
    public double dot(Vector2D v) {
        return this.x * v.x + this.y * v.y;
    }

    // Overriding the toString() method for easy display
    @Override
    public String toString() {
        return "Vector2D(" + x + ", " + y + ")";
    }

    // Static method to create a zero vector
    public static Vector2D zero() {
        return new Vector2D(0, 0);
    }

	public Vector2D copy() {
		return new Vector2D(this.x, this.y);
	}

	public Vector2D limit(double max) {
        if (this.magnitude() > max) {
            return this.normalize().multiply(max);
        }
        return this;
    }

	public Vector2D add(int i) {
		return new Vector2D(this.x + i, this.y + i);
	}
	
	public boolean isZero() {
		return this.x == 0 && this.y == 0;
	}

	public Vector2D multiply(Vector2D scalar) {
		return new Vector2D(this.x * scalar.x, this.y * scalar.y);
	}
	
	public Vector2D divide(Vector2D dividend) {
		return new Vector2D(this.x / dividend.x, this.y / dividend.y);
	}
	
	public float toDeg() {
		float angle = (float) Math.toDegrees(Math.atan2(y, x));

		// Ensure the angle is in the range [0, 360)
		if (angle < 0) {
		    angle += 360;
		}
		return angle;
	}
	
	public Vector2D rotate(float deg) {
        // Convert degrees to radians
        float radians = (float) Math.toRadians(deg);

        // Calculate the new components of the rotated vector
        float cos = (float) Math.cos(radians);
        float sin = (float) Math.sin(radians);

        // Compute the rotated vector components
        float newX = (float) (cos * x - sin * y);
        float newY = (float) (sin * x + cos * y);

        // Return a new vector with the same magnitude as the original
        float magnitude = (float) this.magnitude();
        return new Vector2D(newX, newY).normalize().multiply(magnitude);
    }
}
