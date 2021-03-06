package log4mex.fox.token;

import org.aksw.mex.log4mex.MEXSerializer;
import org.aksw.mex.log4mex.MyMEX;
import org.aksw.mex.util.MEXConstant;
import org.aksw.mex.util.MEXEnum.*;

import java.util.Date;

/**
 * Created by Moussallem on 26.04.16.
 */
public class Dataset5 {

    public static void main(String[] args) {

        System.out.println("starting Fox");

        //the MEX wrapper!
        MyMEX mex = new MyMEX();

        try{

        //basic authoring provenance
        {
            //change later here the sets for adds
            mex.setAuthorName("René Speck");
            mex.setAuthorEmail("speck@informatik.uni-leipzig.de");
            mex.setContext(EnumContexts.NAMED_ENTITY_RECOGNITION);
            mex.setOrganization("Leipzig University");

            mex.setExperimentId("E1_token");
            mex.setExperimentTitle("token-based experiment");
            mex.setExperimentDate(new Date());
            mex.setExperimentDescription("Token-based evaluation on 15 ensemble learning algorithms");
        }

        String eid = "E001S005";
        //ml-experiment-configuration
        {
            mex.addConfiguration(eid);

            mex.Configuration(eid).setDescription("analyzing 10-fold cross validation for 15 algorithms");
            //mex.Configuration(eid).setModel("svm20150322", "model generated by LibSVM", new Date());
            mex.Configuration(eid).setSamplingMethod(EnumSamplingMethods.CROSS_VALIDATION, 10);
            mex.Configuration(eid).SamplingMethod().setTrainSize(0.9);
            mex.Configuration(eid).SamplingMethod().setTestSize(0.1);
            mex.Configuration(eid).SamplingMethod().setSequential(true);

            mex.Configuration(eid).setHardwareConfiguration("ubuntu", EnumProcessors.INTEL_COREI7, EnumRAM.SIZE_16GB, "SSD", EnumCaches.CACHE_3MB);


            mex.Configuration(eid).DataSet().setName("All dataset merged");
            mex.Configuration(eid).DataSet().setDescription("News+News*+Web+Reuter compiled together");
            mex.Configuration(eid).DataSet().setURI("https://github.com/AKSW/FOX/tree/master/input/5");

        }

        /*
        //adding algorithms and parameters
        AlgorithmVO alg1,alg2,alg3,alg4,alg5,alg6,alg7,alg8,alg9,alg10,alg11,alg12,alg13,alg14,alg15,alg16,alg17,alg18,alg19;
        {
            //mex.Configuration(eid).setImplementation(EnumImplementations., "3.6.6");

            alg1 = mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.BaggingJ48);
            alg2 = mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.SequentialMinimalOptimization);
            alg3 = mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.AdditiveLogisticRegression);
            alg4 = mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.DecisionTable);
            alg5 = mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.NaiveBayes);
            alg6 = mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.SimpleVoting);
            alg7 = mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.LogisticModelTrees);
            alg8 = mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.NER_OPEN_NLP);
            alg9 = mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.MultilayerPerceptron);
            alg10 = mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.J48);
            alg11 = mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.NER_STANFORD);
            alg12 = mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.SupportVectorMachines);
            alg13 = mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.NER_ILLINOIS_EXTENDED);
            alg14 = mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.FunctionalTrees);
            alg15 = mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.AdaBoostM1);
            alg16 = mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.ClassLevelVoting);
            alg17 = mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.NER_BALIE);
            alg18 = mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.RandomForest);
            alg19 = mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.LogisticRegression);

            String[] param = {"C", "10^3", "alpha", "0.2"};
            alg1.addParameter(param);
        }
*/
        String ex1;
        String ex2;
        String ex3;
        String ex4;
        String ex5;
        String ex6;
        String ex7;
        String ex8;
        String ex9;
        String ex10;
        String ex11;
        String ex12;
        String ex13;
        String ex14;
        String ex15;
        String ex16;
        String ex17;
        String ex18;
        String ex19;
        
        //associate your run x each algorithm
        {
            ex1 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);

            mex.Configuration(eid).Execution(ex1).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex1).setAlgorithm(mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.SequentialMinimalOptimization));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex1).addPerformance(EnumMeasures.RECALL, .9013);
            mex.Configuration(eid).Execution(ex1).addPerformance(EnumMeasures.PRECISION, .9048);
            mex.Configuration(eid).Execution(ex1).addPerformance(EnumMeasures.F1MEASURE, .9027);
            mex.Configuration(eid).Execution(ex1).addPerformance(EnumMeasures.ERROR, 0.71);
            mex.Configuration(eid).Execution(ex1).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, 0.899);

                //your models call here !
            mex.Configuration(eid).Execution(ex1).setEndDate(new Date());
        }
        
        
         {
            ex2 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex2).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex2).setAlgorithm(mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.AdditiveLogisticRegression));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex2).addPerformance(EnumMeasures.RECALL, .8892);
            mex.Configuration(eid).Execution(ex2).addPerformance(EnumMeasures.PRECISION, .9021);
            mex.Configuration(eid).Execution(ex2).addPerformance(EnumMeasures.F1MEASURE, .8953);
            mex.Configuration(eid).Execution(ex2).addPerformance(EnumMeasures.ERROR, 0.76);
            mex.Configuration(eid).Execution(ex2).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, .892);

                //your models call here !
            mex.Configuration(eid).Execution(ex2).setEndDate(new Date());
        }
         
                 {
            ex3 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex3).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex3).setAlgorithm(mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.DecisionTable));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex3).addPerformance(EnumMeasures.RECALL, .9159);
            mex.Configuration(eid).Execution(ex3).addPerformance(EnumMeasures.PRECISION, .9084);
            mex.Configuration(eid).Execution(ex3).addPerformance(EnumMeasures.F1MEASURE, .9121);
            mex.Configuration(eid).Execution(ex3).addPerformance(EnumMeasures.ERROR, 0.64);
            mex.Configuration(eid).Execution(ex3).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, 0.909);

                //your models call here !
            mex.Configuration(eid).Execution(ex3).setEndDate(new Date());
        }
                 
                {
            ex4 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex4).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex4).setAlgorithm(mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.NaiveBayes));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex4).addPerformance(EnumMeasures.RECALL, .92);
            mex.Configuration(eid).Execution(ex4).addPerformance(EnumMeasures.PRECISION, .8527);
            mex.Configuration(eid).Execution(ex4).addPerformance(EnumMeasures.F1MEASURE, .8846);
            mex.Configuration(eid).Execution(ex4).addPerformance(EnumMeasures.ERROR, 0.89);
            mex.Configuration(eid).Execution(ex4).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, .881);

                //your models call here !
            mex.Configuration(eid).Execution(ex4).setEndDate(new Date());
        }
                                                                      {
            ex5 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex5).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex5).setAlgorithm(mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.NER_OPEN_NLP));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex5).addPerformance(EnumMeasures.RECALL, .7263);
            mex.Configuration(eid).Execution(ex5).addPerformance(EnumMeasures.PRECISION, .7560);
            mex.Configuration(eid).Execution(ex5).addPerformance(EnumMeasures.F1MEASURE, .7265);
            mex.Configuration(eid).Execution(ex5).addPerformance(EnumMeasures.ERROR, 2.19);
            mex.Configuration(eid).Execution(ex5).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, 0.723);
                //your models call here !
            mex.Configuration(eid).Execution(ex5).setEndDate(new Date());
        }  
                                                                                                                                                                             {
           ex6 =  mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex6).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex6).setAlgorithm(mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.SimpleVoting));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex6).addPerformance(EnumMeasures.RECALL, .8185);
            mex.Configuration(eid).Execution(ex6).addPerformance(EnumMeasures.PRECISION, .6996);
            mex.Configuration(eid).Execution(ex6).addPerformance(EnumMeasures.F1MEASURE, .7290);
            mex.Configuration(eid).Execution(ex6).addPerformance(EnumMeasures.ERROR, 2.44);
            mex.Configuration(eid).Execution(ex6).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, .733);

                //your models call here !
            mex.Configuration(eid).Execution(ex6).setEndDate(new Date());
        }
                                                                                                                                                                             
                                                                                                                                                                                                                             {
           ex7 =  mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex7).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex7).setAlgorithm(mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.LogisticModelTrees));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex7).addPerformance(EnumMeasures.RECALL, .9167);
            mex.Configuration(eid).Execution(ex7).addPerformance(EnumMeasures.PRECISION, .9086);
            mex.Configuration(eid).Execution(ex7).addPerformance(EnumMeasures.F1MEASURE, .9126);
            mex.Configuration(eid).Execution(ex7).addPerformance(EnumMeasures.ERROR, 0.64);
            mex.Configuration(eid).Execution(ex7).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, .909);

                //your models call here !
            mex.Configuration(eid).Execution(ex7).setEndDate(new Date());
        }
                                                                                                                                                                                                                             
                                                                                                                                                                                                                                                                                             {
            ex8 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex8).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex8).setAlgorithm(mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.MultilayerPerceptron));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex8).addPerformance(EnumMeasures.RECALL, .9094);
            mex.Configuration(eid).Execution(ex8).addPerformance(EnumMeasures.PRECISION, .9105);
            mex.Configuration(eid).Execution(ex8).addPerformance(EnumMeasures.F1MEASURE, .9099);
            mex.Configuration(eid).Execution(ex8).addPerformance(EnumMeasures.ERROR, 0.66);
            mex.Configuration(eid).Execution(ex8).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, 0.907);

                //your models call here !
            mex.Configuration(eid).Execution(ex8).setEndDate(new Date());
        }
                                                                                                                                                                                                                                                                                                                                                                    {
            ex9 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex9).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex9).setAlgorithm(mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.J48));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex9).addPerformance(EnumMeasures.RECALL, .9146);
            mex.Configuration(eid).Execution(ex9).addPerformance(EnumMeasures.PRECISION, .9098);
            mex.Configuration(eid).Execution(ex9).addPerformance(EnumMeasures.F1MEASURE, .9122);
            mex.Configuration(eid).Execution(ex9).addPerformance(EnumMeasures.ERROR, 0.64);
            mex.Configuration(eid).Execution(ex9).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, 0.909);

                //your models call here !
            mex.Configuration(eid).Execution(ex9).setEndDate(new Date());
        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                   {
            ex10 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex10).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex10).setAlgorithm(mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.NER_STANFORD));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex10).addPerformance(EnumMeasures.RECALL, .9075);
            mex.Configuration(eid).Execution(ex10).addPerformance(EnumMeasures.PRECISION, .8773);
            mex.Configuration(eid).Execution(ex10).addPerformance(EnumMeasures.F1MEASURE, .8921);
            mex.Configuration(eid).Execution(ex10).addPerformance(EnumMeasures.ERROR, 0.78);
            mex.Configuration(eid).Execution(ex10).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, .888);

                //your models call here !
            mex.Configuration(eid).Execution(ex10).setEndDate(new Date());
        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           {
            ex11 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex11).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex11).setAlgorithm(mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.BaggingJ48));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex11).addPerformance(EnumMeasures.RECALL, .9125);
            mex.Configuration(eid).Execution(ex11).addPerformance(EnumMeasures.PRECISION, .91);
            mex.Configuration(eid).Execution(ex11).addPerformance(EnumMeasures.F1MEASURE, .9112);
            mex.Configuration(eid).Execution(ex11).addPerformance(EnumMeasures.ERROR, 0.65);
            mex.Configuration(eid).Execution(ex11).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, .908);

                //your models call here !
            mex.Configuration(eid).Execution(ex11).setEndDate(new Date());
        }    
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 {
            ex12 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex12).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex12).setAlgorithm(mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.SupportVectorMachines));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex12).addPerformance(EnumMeasures.RECALL, .9015);
            mex.Configuration(eid).Execution(ex12).addPerformance(EnumMeasures.PRECISION, .9124);
            mex.Configuration(eid).Execution(ex12).addPerformance(EnumMeasures.F1MEASURE, .9067);
            mex.Configuration(eid).Execution(ex12).addPerformance(EnumMeasures.ERROR, 0.67);
            mex.Configuration(eid).Execution(ex12).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, .903);

                //your models call here !
            mex.Configuration(eid).Execution(ex12).setEndDate(new Date());
        }
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        {
            ex13 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex13).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex13).setAlgorithm(mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.FunctionalTrees));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex13).addPerformance(EnumMeasures.RECALL, .9149);
            mex.Configuration(eid).Execution(ex13).addPerformance(EnumMeasures.PRECISION, .9082);
            mex.Configuration(eid).Execution(ex13).addPerformance(EnumMeasures.F1MEASURE, .9116);
            mex.Configuration(eid).Execution(ex13).addPerformance(EnumMeasures.ERROR, 0.65);
            mex.Configuration(eid).Execution(ex13).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, 0.908);

                //your models call here !
            mex.Configuration(eid).Execution(ex13).setEndDate(new Date());
        }
                        
                                {
            ex14 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex14).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex14).setAlgorithm(mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.AdaBoostM1));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex14).addPerformance(EnumMeasures.RECALL, .9149);
            mex.Configuration(eid).Execution(ex14).addPerformance(EnumMeasures.PRECISION, .9099);
            mex.Configuration(eid).Execution(ex14).addPerformance(EnumMeasures.F1MEASURE, .9124);
            mex.Configuration(eid).Execution(ex14).addPerformance(EnumMeasures.ERROR, 0.64);
            mex.Configuration(eid).Execution(ex14).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, 0.909);
          
                //your models call here !
            mex.Configuration(eid).Execution(ex14).setEndDate(new Date());
        }         
                                                                                                                                                      
                                                                                               {
           ex15 =  mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex15).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex15).setAlgorithm(mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.NER_BALIE));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex15).addPerformance(EnumMeasures.RECALL, .6775);
            mex.Configuration(eid).Execution(ex15).addPerformance(EnumMeasures.PRECISION, .7165);
            mex.Configuration(eid).Execution(ex15).addPerformance(EnumMeasures.F1MEASURE, .694);
            mex.Configuration(eid).Execution(ex15).addPerformance(EnumMeasures.ERROR, 2.09);
            mex.Configuration(eid).Execution(ex15).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, .685);

                //your models call here !
            mex.Configuration(eid).Execution(ex15).setEndDate(new Date());
        }                                                                                             
                                                                                                               {
            ex16 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex16).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex16).setAlgorithm(mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.ClassLevelVoting));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex16).addPerformance(EnumMeasures.RECALL, .9075);
            mex.Configuration(eid).Execution(ex16).addPerformance(EnumMeasures.PRECISION, .8773);
            mex.Configuration(eid).Execution(ex16).addPerformance(EnumMeasures.F1MEASURE, .8921);
            mex.Configuration(eid).Execution(ex16).addPerformance(EnumMeasures.ERROR, 0.78);
            mex.Configuration(eid).Execution(ex16).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, 0.888);

                //your models call here !
            mex.Configuration(eid).Execution(ex16).setEndDate(new Date());
        }

                                                                                                                       {
           ex17 =  mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex17).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex17).setAlgorithm(mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.RandomForest));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex17).addPerformance(EnumMeasures.RECALL, .9158);
            mex.Configuration(eid).Execution(ex17).addPerformance(EnumMeasures.PRECISION, .9097);
            mex.Configuration(eid).Execution(ex17).addPerformance(EnumMeasures.F1MEASURE, .9127);
            mex.Configuration(eid).Execution(ex17).addPerformance(EnumMeasures.ERROR, 0.64);
            mex.Configuration(eid).Execution(ex17).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, 0.909);

                //your models call here !
            mex.Configuration(eid).Execution(ex17).setEndDate(new Date());
        }
                                                                                                                                                                                                                                                              {
            ex18 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex18).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex18).setAlgorithm(mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.NER_ILLINOIS_EXTENDED));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex18).addPerformance(EnumMeasures.RECALL, .8166);
            mex.Configuration(eid).Execution(ex18).addPerformance(EnumMeasures.PRECISION, .7761);
            mex.Configuration(eid).Execution(ex18).addPerformance(EnumMeasures.F1MEASURE, .7954);
            mex.Configuration(eid).Execution(ex18).addPerformance(EnumMeasures.ERROR, 1.48);
            mex.Configuration(eid).Execution(ex18).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, 0.788);

                //your models call here !
            mex.Configuration(eid).Execution(ex18).setEndDate(new Date());
        }
                                                                                                                               {
            ex19 = mex.Configuration(eid).addExecution(EnumExecutionsType.OVERALL, EnumPhases.TEST);
           // mex.Configuration(eid).setExecutionId(0, ex1);

            mex.Configuration(eid).Execution(ex19).setStartDate(new Date());
            mex.Configuration(eid).Execution(ex19).setAlgorithm(mex.Configuration(eid).addAlgorithm("alg", EnumAlgorithmsClasses.LogisticRegression));
            //mex.Configuration(eid).Execution(ex1).setStartsAtPosition("1233");
           // mex.Configuration(eid).Execution(ex1).setEndsAtPosition("1376");
            mex.Configuration(eid).Execution(ex19).addPerformance(EnumMeasures.RECALL, .8869);
            mex.Configuration(eid).Execution(ex19).addPerformance(EnumMeasures.PRECISION, .9057);
            mex.Configuration(eid).Execution(ex19).addPerformance(EnumMeasures.F1MEASURE, .8959);
            mex.Configuration(eid).Execution(ex19).addPerformance(EnumMeasures.ERROR, 0.76);
            mex.Configuration(eid).Execution(ex19).addPerformance(EnumMeasures.MATTHEWSCORRELATIONCOEFICIENT, .892);

                //your models call here !
            mex.Configuration(eid).Execution(ex19).setEndDate(new Date());
        }
                                                                                                                                       
            try{
                MEXSerializer.getInstance().saveToDisk("./metafiles/log4mex/fox/token/5", "http://mex.aksw.org/examples/", mex, MEXConstant.EnumRDFFormats.TTL);
            }catch (Exception e){
                System.out.print(e.toString());
            }

            System.out.println("The MEX file has been successfully created: share it ;-)");

        System.exit(0);

        }catch (Exception e){
            System.out.println(e.toString());
        }


    }

}
