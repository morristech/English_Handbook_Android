package com.zhukovartemvl.home


sealed class HomeState {

    object LoadingDatabaseState : HomeState()
    object DatabaseLoadingErrorState : HomeState()
    object DefaultState : HomeState()

}
