// Joshua Wiley
// mth22113

class vector
{
	private:
		float xC, yC, zC;

	public:
		void setData(float, float, float);
		void vectorsOutput();
		vector add(vector);
		vector subtraction(vector);
		vector cross(vector);
		float dot(vector);
		
};