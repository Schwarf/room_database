package abs.apps.room_database

import ContactScreen
import abs.apps.room_database.ui.theme.Room_databaseTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room

class MainActivity : ComponentActivity() {

    // Bad way to initialize database: Learn about Dependency Injection in Android ... GOT C#
    private val dataBase by lazy {
        Room.databaseBuilder(applicationContext, ContactDatabase::class.java, "contacts.db").build()
    }

    // Bad way to initialize viewModel: Learn about Dependency Injection in Android ... GOT C#
    private val viewModel by viewModels<ContactViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return ContactViewModel(dataBase.dao) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Room_databaseTheme {
                val state by viewModel.state.collectAsState()
                ContactScreen(state = state, onEvent = viewModel::onEvent)
            }
        }
    }
}

