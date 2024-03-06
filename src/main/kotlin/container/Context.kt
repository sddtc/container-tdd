package container

import kotlin.reflect.KClass

class Context {
  private val components = HashMap<KClass<*>, Any>()

  fun <Component : Any> get(type: KClass<Component>): Component {
    return components[type] as Component
  }

  fun <Component : Any> bind(type: KClass<Component>, instance: Component) {
    components[type] = instance
  }
}
