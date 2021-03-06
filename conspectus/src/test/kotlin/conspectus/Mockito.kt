@file:Suppress("nothing_to_inline")

package conspectus

import org.mockito.Mockito

inline fun <reified T> anything(): T = Mockito.argThat { true }

inline fun <reified T : Any> mock() = Mockito.mock(T::class.java) as T
inline fun <reified T : Any> mock(actions: T.() -> Unit): T = Mockito.mock(T::class.java).apply { actions() }

inline fun <T> verifyOnly(mock: T): T = Mockito.verify(mock, Mockito.only())