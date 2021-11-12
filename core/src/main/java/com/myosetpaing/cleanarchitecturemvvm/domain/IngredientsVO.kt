
import com.myosetpaing.cleanarchitecturemvvm.domain.HopsVO
import com.myosetpaing.cleanarchitecturemvvm.domain.MaltVO


data class IngredientsVO(

    val malt: List<MaltVO>,

    val hops: List<HopsVO>,

    val yeast: String

)
