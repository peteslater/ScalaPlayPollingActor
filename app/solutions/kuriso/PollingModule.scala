package solutions.kuriso

import com.google.inject.AbstractModule
import solutions.kuriso.controllers.PollingController

class PollingModule extends AbstractModule {
  override def configure() = {
    bind(classOf[PollingController]).asEagerSingleton()
  }
}
