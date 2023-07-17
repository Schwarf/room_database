import abs.apps.room_database.ContactEvent
import abs.apps.room_database.ContactState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactScreen(
    state: ContactState,
    onEvent: (ContactEvent) -> Unit
) {
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { onEvent(ContactEvent.ShowDialog) }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add contact")
        }
    }
    ) { padding ->
        LazyColumn(
            content = {
                item{
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState())){}
                }
                      }, contentPadding = padding, modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        )
    }
}