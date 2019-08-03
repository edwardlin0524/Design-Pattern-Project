package model;

public class ShapeConfig{
	
    private ShapeColor primaryColor;
    private ShapeColor secondaryColor;
	private Point startPoint;
	private Point endPoint;
	// Following the def of drawRec method:
	// "The left and right edges of the rectangle are at x and x + width.
	// The top and bottom edges are at y and y + height.The rectangle is drawn using
	// the graphics context's current color."
	// So we need to determine which point should be started for drawRec method
	// which means the minimum one, so that
	// drawRec method can draw from left side to right side.
	private Point StartPointForDraw;
	private Point EndPointForDraw;
	private int width;
	private int height;
    private ShapeType shapeType;
    private ShapeShadingType shadingType;
    
    
    public void setPrimaryColor(ShapeColor primaryColor) {
        this.primaryColor = primaryColor;
    }

    public void setSecondaryColor(ShapeColor secondaryColor) {
        this.secondaryColor = secondaryColor;
    }
    
    public ShapeColor getPrimaryColor() {
        return primaryColor;
    }

    public ShapeColor getSecondaryColor() {
        return secondaryColor;
    }

    public void setShadingType(ShapeShadingType shadingType) {
        this.shadingType = shadingType;
    }

    public void setShapeType(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }
    public ShapeShadingType getShadingType() {
        return shadingType;
    }

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	
	public Point getStartPoint() {
		return startPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setStartPointForDraw(Point adjustedStart) {
		this.StartPointForDraw = adjustedStart;
	}

	public Point getStartPointForDraw() {
		int startX = Math.min(startPoint.getX(), endPoint.getX());
		int startY = Math.min(startPoint.getY(), endPoint.getY());
		return new Point(startX, startY);
	}
	
	public void setEndPointForDraw(Point adjustedEnd) {
		this.EndPointForDraw = adjustedEnd;
	}

	public Point getEndPointForDraw() {
		int endX = Math.max(startPoint.getX(), endPoint.getX());
		int endY = Math.max(startPoint.getY(), endPoint.getY());
		return new Point(endX, endY);
	}


	public void setWidth(int width) {
		this.width = width;
	}

	public int getWidth() {
		Point Start = getStartPointForDraw();
		Point End = getEndPointForDraw();
		return End.getX() - Start.getX();
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHeight() {
		Point Start = getStartPointForDraw();
		Point End = getEndPointForDraw();
		return End.getY() - Start.getY();
	}
	


}
