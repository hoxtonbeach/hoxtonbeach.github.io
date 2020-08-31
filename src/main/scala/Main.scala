import org.scalajs.dom
import org.scalajs.dom.document

object Main {
  def main(args: Array[String]): Unit = {
    document.addEventListener("DOMContentLoaded", { (e: dom.Event) =>
      setupUI()
    })
  }

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    parNode.textContent = text
    targetNode.appendChild(parNode)
  }

  def setupUI(): Unit = {
    val button = document.createElement("button")

    button.textContent = "Click me!"
    button.addEventListener("click", { (e: dom.MouseEvent) =>
      addClickedMessage()
    })
    document.body.appendChild(button)
  }

  def addClickedMessage(): Unit = {
    appendPar(document.body, "You clicked the button to let me know!")
  }
}
