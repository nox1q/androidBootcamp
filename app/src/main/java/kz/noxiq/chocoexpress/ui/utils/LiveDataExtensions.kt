package kz.noxiq.chocoexpress.ui.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kz.noxiq.chocoexpress.ui.utils.Event

fun <T> LiveData<T>.observe(
    lifecycleOwner: LifecycleOwner,
    onReceive: (T) -> Unit
) = observe(lifecycleOwner, Observer { value -> onReceive(value) })

fun <T> LiveData<Event<T>>.observeEvent(
    lifecycleOwner: LifecycleOwner,
    onReceive: (T) -> Unit
) {
    val observer = Observer<Event<T>> { event ->
        val content: T = event.getContentIfNotHandled() ?: return@Observer
        onReceive(content)
    }
    observe(lifecycleOwner, observer)
}