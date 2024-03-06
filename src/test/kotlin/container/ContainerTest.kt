package container

import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class ContainerTest {
  interface Component

  @Test
  fun `bind type to a specific instance`() {
    val context = Context()
    val instance = object : Component {}

    context.bind(Component::class, instance)

    assertSame(instance, context.get(Component::class))
  }
//
//  @Test
//  fun `bind type to a implementation class`() {
//  }
}
