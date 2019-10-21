# KotlinCoroutineExample
Coroutines are a Kotlin feature that convert async callbacks for long-running tasks, such as database or network access, into sequential code.
Coroutine are light-weight threads. A light weight thread means it doesn’t map on native thread, so it doesn’t require context switching on processor, so they are faster.
Coroutines are available in many languages.
Basically, there are two types of Coroutines:
Stackless
Stackful
Kotlin implements stackless coroutines — it’s mean that the coroutines don’t have own stack, so they don’t map on native thread.
Coroutines and the threads both are multitasking. But the difference is that threads are managed by the OS and coroutines by the users.(#Ref :mindOrks)
