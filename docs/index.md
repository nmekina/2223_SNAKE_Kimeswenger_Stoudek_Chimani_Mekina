# My First Website

## Snake Projekt:

[Erklärung](startmenue.md)

[Das Spiel](ui.md)

[Projektstruktur und -informationen](project.md)

### Entwickler:
{% for element in site.data.student %}
- {{element.firstname}} {{element.lastname}}, {{element.class}}, {{element.task}}
{% endfor %}
[Erfahren Sie mehr über die Entwickler](about_us.md)
