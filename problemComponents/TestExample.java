package problemComponents;

import java.util.ArrayList;

/**
 * Represents a data point with an unknwon value, which needs to be predicted using the training examples.
 * 
 * In addition to the collection of known features of this data point, TestExamples also have an unknown
 * feature which has a specified position in the collection of features.
 * 
 * Methods exist to access and alter this unknown feature and its position, as well as to convert the
 * TestExample into a TrainingExample.
 * 
 * @author Luke Newton
 */
public class TestExample extends Example {
	//autogenerated serialization ID for saving object to a file
	private static final long serialVersionUID = 7630969153852978010L;
	//the unknown feature to be predicted
	private Feature unknownFeature;
	//the position of the unknown feature in the ordered collection of all features within the data point
	private int unknownFeaturePosition;
	
	/**
	 * Constructor
	 * 
	 * @param knownFeatures the collection of known features in this data point
	 * @param unknownPos the position the unknown feature should be inserted into in the known feature collection
	 */
	public TestExample(ArrayList<Feature> knownFeatures, int unknownPos){
		super();
		fields = knownFeatures;
		unknownFeature = knownFeatures.get(unknownPos);
		unknownFeaturePosition = unknownPos;
	}
	
	/**
	 * Constructor. Defaults unknown position to last element in array
	 * 
	 * @param knownFeatures the collection of known features in this data point
	 */
	public TestExample(ArrayList<Feature> knownFeatures){
		this(knownFeatures, knownFeatures.size() - 1);
	}

	/** 
	 * Converts this TestExample into a TrainingExample with the unknwon feautre
	 * inserted appropriately into the feature collection.
	 * 
	 * @return a TrainingExample with all known features and unknown feautre in one collection
	 */
	public TrainingExample toTrainingExample(){
		ArrayList<Feature> features = fields;
		return new TrainingExample(features);
	}
	
	@Override
	public String toString(){
		return this.toTrainingExample().toString();
	}
	
	@Override
	public boolean equals(Object o){
		if(!(o instanceof TestExample))
			return false;
		
		ArrayList<Feature> oFields = ((TestExample)o).getFields();

		int maxSize =  Math.min(fields.size(), oFields.size());
		for(int i = 0; i < maxSize; i++){	
			if(fields.get(i) == null || oFields.get(i) == null)
				continue;	
			else if(!fields.get(i).equals(oFields.get(i)))
				return false;
		}
		return true;
	}
	
	/** returns the unknown feature value in this TestExample */
	public Feature getUnknownFeature() {
		return unknownFeature;
	}

	/** Update the unknown feature value in this TestExample */
	public void setUnknownFeature(Feature unknownFeature) {
		this.unknownFeature = unknownFeature;
	}

	/* return the position of the unknown feature in this TestExample */
	public int getUnknownFeaturePosition() {
		return unknownFeaturePosition;
	}

	/*Update the position of the unknown feature in this TestExample */
	public void setUnknownFeaturePosition(int unknownFeaturePosition) {
		this.unknownFeaturePosition = unknownFeaturePosition;
	}
}