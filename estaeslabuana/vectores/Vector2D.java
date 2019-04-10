package com.example.ronri.estaeslabuana.vectores;

public class Vector2D {
	private double x;
	private double y;
	public Vector2D(double x,double y){
		this.x = x;
		this.y = y;
	}
	public Vector2D(){
		x = 0;
		y = 0;
	}
	public double getMagnitud(){
		return Math.sqrt(x*x + y*y);
	}
	public Vector2D setDireccion(double angulo){
		double magnitud = getMagnitud();
		return new Vector2D(Math.cos(angulo)*magnitud, Math.sin(angulo)*magnitud);
	}
	public Vector2D normalizar()
	{
		double magnitud = getMagnitud();
		return new Vector2D(x / magnitud, y /magnitud);
	}
	public Vector2D limite(double value){
		if(getMagnitud() > value)
		{
			return this.normalizar().aceleracion(value);
		}
		return this;
	}
	public Vector2D aceleracion(double value)
	{
		return new Vector2D(x*value, y*value);
	}
	public Vector2D add(Vector2D v)
	{
		return new Vector2D(x + v.getX(), y + v.getY());
	}
	public Vector2D substracto(Vector2D v)
	{
		return new Vector2D(x - v.getX(), y - v.getY());
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getAngulo(){
		return Math.asin(y/getMagnitud());
	}
	
}
