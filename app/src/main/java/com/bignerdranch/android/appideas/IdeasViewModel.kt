import androidx.lifecycle.ViewModel
import com.bignerdranch.android.appideas.Ideas
import com.bignerdranch.android.appideas.R

private const val TAG = "IdeasViewModel"

class IdeasViewModel : ViewModel() {

    var ideasBank = mutableListOf(
        Ideas("idea 1"),
        Ideas("idea 2")
    )
    private var currentIndex = 0

//    val currentIdeaText: Int
//        get() = ideasBank[currentIndex].textResId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % ideasBank.size
    }
}