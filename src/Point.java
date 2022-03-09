public class Point {

	public Point nNeighbor;
	public Point wNeighbor;
	public Point eNeighbor;
	public Point sNeighbor;
	public float nVel;
	public float eVel;
	public float wVel;
	public float sVel;
	public float pressure;

	public static Integer []types ={0,1,2};
	int type;

	int sinInput;

	public Point() {

		clear();
		type = 0;
		sinInput = 0;
	}

	public void clicked() {
		pressure = 1;
	}
	
	public void clear() {
		//clear velocity and pressure
		nVel = 0;
		eVel = 0;
		wVel = 0;
		sVel = 0;
		pressure = 0;
	}

	public void updateVelocity() {
		//velocity update
		if(type == 0) {
			nVel = nVel - (nNeighbor.getPressure() - pressure);
			eVel = eVel - (eNeighbor.getPressure() - pressure);
			wVel = wVel - (wNeighbor.getPressure() - pressure);
			sVel = sVel - (sNeighbor.getPressure() - pressure);
		}
	}

	public void updatePresure() {
		//pressure update
		if(type == 0){
			pressure = pressure - 0.5f*(nVel+eVel+wVel+sVel);
		}
		else if(type == 2){
			sinInput = (sinInput+60)%361;
			double radians = Math.toRadians(sinInput);
			pressure = (float) (Math.sin(radians));
		}
	}

	public float getPressure() {
		return pressure;
	}
}