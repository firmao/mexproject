package org.aksw.mex.log4mex.core;

import org.aksw.mex.util.MEXEnum;

/**
 * Created by esteves on 26.06.15.
 */
public class PhaseVO {

    private MEXEnum.EnumPhases _phase;
    private String _label = "";

    public PhaseVO(MEXEnum.EnumPhases value){
        this._phase = value;
        if (value.toString().length() > 2)
            this._label = value.toString().substring(0, 1).toUpperCase() + value.toString().substring(1);
    }

    public MEXEnum.EnumPhases getName(){
        return this._phase;
    }

    public String getLabel(){
        return this._label;
    }

}