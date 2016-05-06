package org.aksw.mex.log4mex.core;

import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import org.aksw.mex.log4mex.algo.AlgorithmVO;
import org.aksw.mex.log4mex.perf.example.ExamplePerformanceMeasureVO;
import org.aksw.mex.log4mex.perf.overall.*;
import org.aksw.mex.util.MEXEnum;
import org.apache.commons.lang3.EnumUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by esteves on 26.06.15.
 */
public abstract class Execution {

    protected String                    _id;
    protected String                    _targetClass;
    protected Boolean                   _grouped;
    protected Date                      _startedAtTime;
    protected Date                      _endedAtTime;

    protected ExperimentConfigurationVO _expConf;
    protected PhaseVO                   _phase;
    protected AlgorithmVO               _algo;
    protected ModelVO                   _model;

    protected List<ExampleVO>           _examples;
    protected List<Measure>             _performances;

    public Execution(){
        this._performances = new ArrayList<>();
        this._examples = new ArrayList();
    }


    /**********************************************************************************************************************************************
     *                                                                  getters
     **********************************************************************************************************************************************/

    /**
     * gets the id of an execution
     * @return
     */
    public String getId() {
        return _id;
    }

    /**
     * gets the target class for given execution
     * @return
     */
    public String getTargetClass() {
        return _targetClass;
    }

    /**
     * gets the start time for given execution
     * @return
     */
    public Date getStartedAtTime() {
        return _startedAtTime;
    }

    /**
     * gets end time for given execution
     * @return
     */
    public Date getEndedAtTime() {
        return _endedAtTime;
    }

    /**
     * gets grouped characteristic of given execution
     * i.e.: true = mexcore:OverallExecution and false = mexcore:SingleExecution
     * @return
     */
    public Boolean getGrouped() {
        return _grouped;
    }

    /**
     * gets the Phase associated to an Execution
     * @return
     */
    public PhaseVO getPhase() {
        return _phase;
    }

    /**
     * gets the Algorithm associated to an Execution
     * @return
     */
    public AlgorithmVO getAlgorithm() {
        return _algo;
    }

    /**
     * gets the Model associated to an Execution
     * @return
     */
    public ModelVO getModel() {
        return _model;
    }

    /**
     * gets the ExperimentConfiguration which groups an Execution
     * @return
     */
    public ExperimentConfigurationVO getExpConf() {
        return _expConf;
    }

    /**
     * gets the Performance measures for an Execution
     * @return
     */
    public List<Measure> getPerformances() {
        return _performances;
    }

    /**
     * gets the Example (in case of mexcore:SingleExecution) or Examples (in case of a mexcore:OverallExecution)
     * associated to an Execution. It is worth to note that we always have a list of Examples once we each cell
     * in a table is an mexcore:Example class. mexcore:datasetColumn and mexcore:datasetRow indicate the position
     * and prov:value contains the desired value of a cell
     * @return
     */
    public List<ExampleVO> getExamples(){
        return this._examples;
    }

    /**
     * gets all the mexcore:ClassificationMeasure generated by an Execution
     * @return
     */
    public List<ClassificationMeasureVO> getClassificationPerformance() {
        List<ClassificationMeasureVO> classifications = null;
        Collection<Measure> t
                = Collections2.filter(this._performances, p -> p instanceof ClassificationMeasureVO);
        if (t != null && t.size() >0){
            classifications = new ArrayList(t);
        }
        return classifications;
    }
    
    /**********************************************************************************************************************************************
     *                                                                  setters
     **********************************************************************************************************************************************/

    public abstract void setStartsAtPosition(String value);

    public abstract void setEndsAtPosition(String value);

    public void setId(String value){
        this._id = value;
    }

    public void setTargetClass(String _targetClass) {
        this._targetClass = _targetClass;
    }

    public void setStartDate(Date value){
        this._startedAtTime = value;
    }

    public void setEndDate(Date value){
        this._endedAtTime = value;
    }

    public void setExperimentConfiguration(ExperimentConfigurationVO value){
        this._expConf = value;
    }

    public void setModel(ModelVO value){ this._model = value;}

    public void setAlgorithm(AlgorithmVO value){
        this._algo = value;
    }

    public boolean setAlgorithm(String instanceName) throws Exception{
        try{
            //check whether the algorithm exists into the experiment configuration
            Collection<AlgorithmVO> t
                    = Collections2.filter(this.getExpConf().getAlgorithms(), p -> (p instanceof AlgorithmVO && p.getIndividualName().equals(instanceName)));
            if (t != null && t.size() > 0){
                this._algo = Iterables.get(t, 0);
            }else{
                throw new Exception("The algorithm (instanceName = " + instanceName + ") does not exists for the experiment");
            }

        }catch (Exception e){
            throw new Exception(e);
        }
        return true;
    }

    public void setGrouped(Boolean _grouped) {
        this._grouped = _grouped;
    }

    public void setStartedAtTime(Date _startedAtTime) {
        this._startedAtTime = _startedAtTime;
    }

    public void setEndedAtTime(Date _endedAtTime) {
        this._endedAtTime = _endedAtTime;
    }

    public void setExpConf(ExperimentConfigurationVO _expConf) {
        this._expConf = _expConf;
    }

    public void setAlgo(AlgorithmVO _algo) {
        this._algo = _algo;
    }

    public void setPhase(PhaseVO value){
        this._phase = value;
    }

    /**********************************************************************************************************************************************
     *                                                                  functions
     ***********************************************************************************************************************************************/


    /***
     * add UserDefinedMeasure
     * @param id
     * @param description
     * @param formula
     * @param value
     * @return
     */
    public boolean addPerformance(String id, String description, String formula, Double value){
        UserDefinedMeasureVO m = new UserDefinedMeasureVO(id, description, formula, value);
        return this._performances.add(m);
    }


    /**
     * add PerformanceMeasure
     * @param exampleIdentifier
     * @param predictedValue
     * @param realValue
     * @return
     */
    public boolean addPerformance(String exampleIdentifier, String predictedValue, String realValue){
        ExamplePerformanceMeasureVO m = new ExamplePerformanceMeasureVO(exampleIdentifier, predictedValue, realValue);
        return this._performances.add(m);
    }

    /***
     * add PerformanceMeasure (related to OverallExecution)
     * @param m
     * @param v
     * @return
     */
    public boolean addPerformance(MEXEnum.EnumMeasures m, double v){
        String type = "";
        String p = m.toString().replace("_","").toUpperCase();
        String paux = m.toString().replace("_","");

        boolean ret = false;

        try{
            type = "cla";
            if (EnumUtils.isValidEnum(MEXEnum.EnumClassificationMeasure.class, p) == false){
                type = "reg";
                if (EnumUtils.isValidEnum(MEXEnum.EnumRegressionMeasure.class, p) == false){
                    type = "sta";
                    if (EnumUtils.isValidEnum(MEXEnum.EnumStatisticalMeasure.class, p) == false){
                        type = "clu";
                        if (EnumUtils.isValidEnum(MEXEnum.EnumClusteringMeasure.class, p) == false){
                            return false;}
                    }
                }
            }

            switch (type) {
                case "cla":
                    ret = addClassificationPerformance(paux,v);
                    break;
                case "reg":
                    ret =  addRegressionPerformance(paux,v);
                    break;
                case "sta":
                    ret = addStatisticalPerformance(paux,v);
                    break;
                case "clu":
                    ret = addClusteringPerformance(paux,v);
                    break;
                default:
                    ret = false;
                    break;
            }

        }catch (Exception e){
            return false;}

        finally {
            return ret;}

    }

    private boolean addClassificationPerformance(String p, double value) {
        ClassificationMeasureVO m = new ClassificationMeasureVO();
        m.setValue(value);
        m.setName(p);
        return this._performances.add(m);
    }

    private boolean addRegressionPerformance(String p, double value) {
        RegressionMeasureVO m = new RegressionMeasureVO();
        m.setValue(value);
        m.setName(p);
        return this._performances.add(m);
    }

    private boolean addStatisticalPerformance(String p, double value) {
        StatisticalMeasureVO m = new StatisticalMeasureVO();
        m.setValue(value);
        m.setName(p);
        return this._performances.add(m);
    }

    private boolean addClusteringPerformance(String p, double value) {
        ClusteringMeasureVO m = new ClusteringMeasureVO();
        m.setValue(value);
        m.setName(p);
        return this._performances.add(m);
    }


}
