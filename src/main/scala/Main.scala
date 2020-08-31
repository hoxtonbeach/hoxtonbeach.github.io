import org.scalajs.dom
import org.scalajs.dom.html.{Audio, Image}
import org.scalajs.dom.{document, html}
import org.scalajs.dom.raw.Element

object Main {
  def main(args: Array[String]): Unit = {
    document.addEventListener("DOMContentLoaded", { (e: dom.Event) =>
      setupUI()
    })
  }

  def setupUI(): Unit = {
    val button = document.createElement("button")

    button.textContent = "Click me!"
    button.addEventListener("click", { (e: dom.MouseEvent) =>
      calculate()
    })

    document.body.appendChild(form)
    document.body.appendChild(button)
  }

  def appendPar(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    parNode.textContent = text
    targetNode.appendChild(parNode)
  }

  def form: Element = {
    val form = document.createElement("form")
    form.appendChild(boxLabel("Hours:", "hours"))
    form.appendChild(hoursBox)
    form.appendChild(br)
    form.appendChild(boxLabel("Takings:", "takings"))
    form.appendChild(takingsBox)
    form
  }

  def boxLabel(text: String, `for`: String): Element = {
    val textBox = document.createElement("label")
    textBox.setAttribute(`for`, "hours")
    textBox.innerHTML = text
    textBox
  }

  def hoursBox: Element = {
    val textBox = document.createElement("input")
    textBox.setAttribute("type", "number")
    textBox.setAttribute("id", "hours")
    textBox
  }

  def takingsBox: Element = {
    val textBox = document.createElement("input")
    textBox.setAttribute("type", "number")
    textBox.setAttribute("id", "takings")
    textBox
  }

  def br: Element = {
    document.createElement("br")
  }

  def isProfit(): Boolean = {
    document.getElementById("hours")
    val hours =
      document.getElementById("hours").asInstanceOf[html.Input].value.toInt
    val takings =
      document.getElementById("takings").asInstanceOf[html.Input].value.toInt

    val cost = hours * 10.5
    val net = takings * 0.95

    cost < (net / 3)
  }

  def calculate(): Unit = {
    val (audio, image) = if (isProfit()) {
      (fanfareAudio, happyImage)
    } else {
      (sadAudio, sadImage)
    }
    document.body.innerHTML = ""
    document.body.appendChild(image)
    document.body.appendChild(br)
    document.body.appendChild(reloadButton)
    audio.play()
  }

  def reloadButton: Element = {
    val button = document.createElement("button")
    button.textContent = "Try Again"
    button.addEventListener("click", { (e: dom.MouseEvent) =>
      dom.window.location.reload()
    })
    button
  }

  def sadImage: Image = {
    val boss = document.createElement("img")
    val bImage = boss.asInstanceOf[Image]
    bImage.src = "sadboss.gif"
    bImage
  }
  def happyImage: Image = {
    val will = document.createElement("img")
    val wImage = will.asInstanceOf[Image]
    wImage.src = "will.gif"
    document.body.appendChild(wImage)
    wImage
  }

  def sadAudio: Audio = {
    val audio = document.createElement("audio").asInstanceOf[Audio]
    audio.src = "sadtrombone.mp3"
    audio
  }

  def fanfareAudio: Audio = {
    val audio = document.createElement("audio").asInstanceOf[Audio]
    audio.src = "fanfare.mp3"
    audio
  }
}
