package edu.jhu.jacana.align.feature

import edu.jhu.jacana.align.AlignPair
import edu.jhu.jacana.align.AlignFeatureVector
import edu.jhu.jacana.align.resource.GizaReverseAlign
import edu.jhu.jacana.align.IndexLabelAlphabet.NONE_STATE
import edu.jhu.jacana.align.Alphabet
import edu.jhu.jacana.align.util.AlignerParams

object Model4ReverseAlignFeature extends AlignFeature {
    
    val FEAT_NAME = "model4R"

    override def init() { 
        GizaReverseAlign.isAligned("train0", 0, 0)
    }
    
 	def addPhraseBasedFeature(pair: AlignPair, ins:AlignFeatureVector, i:Int, srcSpan:Int, j:Int, tgtSpan:Int, currState:Int, featureAlphabet: Alphabet) {
 		if (j == -1) {
		} else {
		    if (!AlignerParams.phraseBased) {
		    	if (srcSpan == 1 && tgtSpan == 1)
            ins.addFeature(FEAT_NAME, NONE_STATE, currState, GizaReverseAlign.isAligned(pair.id, i, j), srcSpan, featureAlphabet)
		      }
		}
	
	}
}
