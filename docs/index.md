# My First Website

Snake Projekt:

[Erfahren Sie mehr über die Entwickler](about_us.md)

[Startmenue](startmenue.md)

[Das Spiel](ui.md)

[Projektstruktur und -informationen](project.md)

{% for element in site.data.student %}
- {{element.firstname}} {{element.lastname}},{{element.class}}
{% endfor %}
