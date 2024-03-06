package container

import kotlin.reflect.KClass

class Context {
  val components = HashMap<KClass<*>, Any>()
  val implementations = HashMap<KClass<*>, KClass<*>>()

  inline fun <reified Component : Any> get(type: KClass<Component>): Component {
    if(components.contains(type)) {
      return components[type] as Component
    }
    return implementations[type]?.java?.getDeclaredConstructor()?.newInstance() as Component
  }

  fun <Component : Any> bind(type: KClass<Component>, instance: Component) {
    components[type] = instance
  }

  fun <Component : Any, Implementation: Component> bind(type: KClass<Component>, implementation: KClass<Implementation>) {
    implementations[type] = implementation
  }
}
